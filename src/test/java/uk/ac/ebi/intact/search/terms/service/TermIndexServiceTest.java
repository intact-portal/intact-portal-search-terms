package uk.ac.ebi.intact.search.terms.service;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import uk.ac.ebi.intact.search.terms.model.Term;
import uk.ac.ebi.intact.search.terms.service.util.RequiresSolrServer;

import javax.annotation.Resource;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Elisabet Barrera
 */
public class TermIndexServiceTest {


    private Term term1;
    private Term term2;
    private Term term3;

    @Resource
    private TermIndexService termIndexService;

    @Resource
    private TermSearchService termSearchService;

    public static @ClassRule
    RequiresSolrServer requiresRunningServer = RequiresSolrServer.onLocalhost();

    @Before
    public void setUp() throws Exception {

        //Delete all documents from solr core
        termIndexService.deleteAll();

        //Create new interactors documents
        term1 = new Term("termId1",
                "termName1",
                Arrays.asList("term1_syn1", "term1_syn2", "term1_syn3", "term1_syn4"),
                "termType1",
                "parentTerm1",
                "parentTermName1",
                Arrays.asList("paretn_term1_syn1", "parent_term1_syn2", "parent_term1_syn3"),
                "ontology1",
                "definition1",
                20);

        term2 = new Term("termId2",
                "termName2",
                Arrays.asList("term2_syn1", "term2_syn2", "term2_syn3", "term2_syn4"),
                "termType1",
                "parentTerm2",
                "parentTermName2",
                Arrays.asList("paretn_term2_syn1", "parent_term2_syn2", "parent_term2_syn3"),
                "ontology2",
                "definition2",
                15);

        term3 = new Term("termId3",
                "termName3",
                Arrays.asList("term3_syn1", "term3_syn2", "term3_syn3", "term3_syn4"),
                "termType1",
                "parentTerm3",
                "parentTermName3",
                Arrays.asList("parent_term3_syn1", "parent_term3_syn2", "parent_term3_syn3"),
                "ontology3",
                "definition3",
                5);
    }

    @Test
    public void triggerSchemaUpdateOnFirstSave() {
        termIndexService.save(term1);

        Term term = termSearchService.findBy("termId1");
        assertEquals(term.getDbOntology(), term1.getDbOntology());
        assertEquals(termSearchService.countDocuments(), 1);
    }

    @Test
    public void triggerSchemaUpdateOnSaveCollection() {
        // empty collection
        termIndexService.deleteAll();

        termIndexService.save(Arrays.asList(term1, term2, term3));
        assertEquals(termSearchService.countDocuments(), 3);
    }

    @Test
    public void deleteCollection() {
        // empty collection
        termIndexService.deleteAll();
        assertEquals(termSearchService.countDocuments(), 0);
    }

}