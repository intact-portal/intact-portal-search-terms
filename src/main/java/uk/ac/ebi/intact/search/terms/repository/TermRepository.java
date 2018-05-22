package uk.ac.ebi.intact.search.terms.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;
import uk.ac.ebi.intact.search.terms.model.Term;

/**
 * @author Elisabet Barrera
 */
@Repository
public interface TermRepository extends SolrCrudRepository<Term, String> {
}
