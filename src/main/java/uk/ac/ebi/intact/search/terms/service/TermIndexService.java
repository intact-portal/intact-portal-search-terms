package uk.ac.ebi.intact.search.terms.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.ebi.intact.search.terms.model.SearchTerm;
import uk.ac.ebi.intact.search.terms.repository.TermRepository;

/**
 * @author Elisabet Barrera
 */
@Service
public class TermIndexService {

    private final TermRepository termRepository;

    public TermIndexService(@Qualifier("termRepository") TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    @Transactional
    public void deleteAll() {
        this.termRepository.deleteAll();
    }

    @Transactional
    public void save(SearchTerm searchTerm) {
        this.termRepository.save(searchTerm);
    }

    @Transactional
    public void save(Iterable<SearchTerm> searchTerms) {
        this.termRepository.saveAll(searchTerms);
    }

    @Transactional
    public void delete(SearchTerm id) {
        this.termRepository.delete(id);
    }
}
