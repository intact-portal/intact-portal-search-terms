package uk.ac.ebi.intact.search.terms.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

/**
 * @author Elisabet Barrera
 */
@SolrDocument(solrCoreName = "terms")
public class Term {

    @Id
    @Field("term_id")
    @Indexed
    private String term_id;

    @Field("term_name")
    private String term_name;

    @Field("term_synonyms")
    private List<String> term_synonyms;

    @Field("term_type")
    private String term_type;

    @Field("parent_term_id")
    private String parent_term_id;

    @Field("parent_term_name")
    private String parent_term_name;

    @Field("parent_term_synonyms")
    private List<String> parent_term_synonyms;

    @Field("dbOntology")
    private String dbOntology;

    @Field("definition")
    private String definition;

    @Field("interaction_count")
    private Integer interactionCount;

    public Term() {
    }

    public Term(String term_id, String term_name, List<String> term_synonyms, String term_type, String parent_term_id,
                String parent_term_name, List<String> parent_term_synonyms, String dbOntology, String definition,
                Integer interactionCount) {
        this.term_id = term_id;
        this.term_name = term_name;
        this.term_synonyms = term_synonyms;
        this.term_type = term_type;
        this.parent_term_id = parent_term_id;
        this.parent_term_name = parent_term_name;
        this.parent_term_synonyms = parent_term_synonyms;
        this.dbOntology = dbOntology;
        this.definition = definition;
        this.interactionCount = interactionCount;
    }

    public String getTerm_id() {
        return term_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    public String getTerm_name() {
        return term_name;
    }

    public void setTerm_name(String term_name) {
        this.term_name = term_name;
    }

    public List<String> getTerm_synonyms() {
        return term_synonyms;
    }

    public void setTerm_synonyms(List<String> term_synonyms) {
        this.term_synonyms = term_synonyms;
    }

    public String getTerm_type() {
        return term_type;
    }

    public void setTerm_type(String term_type) {
        this.term_type = term_type;
    }

    public String getParent_term_id() {
        return parent_term_id;
    }

    public void setParent_term_id(String parent_term_id) {
        this.parent_term_id = parent_term_id;
    }

    public String getParent_term_name() {
        return parent_term_name;
    }

    public void setParent_term_name(String parent_term_name) {
        this.parent_term_name = parent_term_name;
    }

    public List<String> getParent_term_synonyms() {
        return parent_term_synonyms;
    }

    public void setParent_term_synonyms(List<String> parent_term_synonyms) {
        this.parent_term_synonyms = parent_term_synonyms;
    }

    public String getDbOntology() {
        return dbOntology;
    }

    public void setDbOntology(String dbOntology) {
        this.dbOntology = dbOntology;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Integer getInteractionCount() {
        return interactionCount;
    }

    public void setInteractionCount(Integer interactionCount) {
        this.interactionCount = interactionCount;
    }

    @Override
    public String toString() {
        return "Term{" +
                "term_id='" + term_id + '\'' +
                ", term_name='" + term_name + '\'' +
                ", term_synonyms=" + term_synonyms +
                ", term_type='" + term_type + '\'' +
                ", parent_term_id='" + parent_term_id + '\'' +
                ", parent_term_name='" + parent_term_name + '\'' +
                ", parent_term_synonyms=" + parent_term_synonyms +
                ", dbOntology='" + dbOntology + '\'' +
                ", definition='" + definition + '\'' +
                ", interactionCount=" + interactionCount +
                '}';
    }
}
