package uk.ac.ebi.intact.search.terms.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uk.ac.ebi.intact.search.terms.model.SearchTerm;
import uk.ac.ebi.intact.search.terms.repository.TermRepository;

import java.util.Optional;

/**
 * @author Elisabet Barrera
 */
@Service
public class TermSearchService {

    private final TermRepository termRepository;

    public TermSearchService(@Qualifier("termRepository") TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    public Iterable<SearchTerm> findAll() {
        return this.termRepository.findAll();
    }

    public Optional<SearchTerm> findById(String id) {
        return this.termRepository.findById(id);
    }

    public long countDocuments() {
        return this.termRepository.count();
    }
}
