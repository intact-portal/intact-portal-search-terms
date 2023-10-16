package uk.ac.ebi.intact.search.terms.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.ac.ebi.intact.search.terms.model.SearchTerm;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * @author Elisabet Barrera
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TermIndexServiceTest {


    private SearchTerm searchTerm1;
    private SearchTerm searchTerm2;
    private SearchTerm searchTerm3;

    @Resource
    private TermIndexService termIndexService;

    @Resource
    private TermSearchService termSearchService;

    @Before
    public void setUp() {

        //Delete all documents from solr core
        termIndexService.deleteAll();

        //Create new interactors documents
        searchTerm1 = new SearchTerm("termId1",
                "termName1",
                Arrays.asList("term1_syn1", "term1_syn2", "term1_syn3", "term1_syn4"),
                "termType1",
                "parentTerm1",
                "parentTermName1",
                Arrays.asList("paretn_term1_syn1", "parent_term1_syn2", "parent_term1_syn3"),
                "ontology1",
                "definition1",
                20);

        searchTerm2 = new SearchTerm("termId2",
                "termName2",
                Arrays.asList("term2_syn1", "term2_syn2", "term2_syn3", "term2_syn4"),
                "termType1",
                "parentTerm2",
                "parentTermName2",
                Arrays.asList("paretn_term2_syn1", "parent_term2_syn2", "parent_term2_syn3"),
                "ontology2",
                "definition2",
                15);

        searchTerm3 = new SearchTerm("termId3",
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
        termIndexService.save(searchTerm1);

        Optional<SearchTerm> searchTerm = termSearchService.findById("termId1");
        assertEquals(searchTerm.get().getDbOntology(), searchTerm1.getDbOntology());
        assertEquals(termSearchService.countDocuments(), 1);
    }

    @Test
    public void triggerSchemaUpdateOnSaveCollection() {
        // empty collection
        termIndexService.deleteAll();

        termIndexService.save(Arrays.asList(searchTerm1, searchTerm2, searchTerm3));
        assertEquals(termSearchService.countDocuments(), 3);
    }

    @Test
    public void deleteCollection() {
        // empty collection
        termIndexService.deleteAll();
        assertEquals(termSearchService.countDocuments(), 0);
    }

}