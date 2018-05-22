package uk.ac.ebi.intact.search.terms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uk.ac.ebi.intact.search.terms.model.Term;
import uk.ac.ebi.intact.search.terms.repository.TermRepository;

/**
 * @author Elisabet Barrera
 */
@Service
public class TermSearchService {

    @Autowired
    @Qualifier("termRepository")
    private TermRepository termRepository;

    public Iterable<Term> findAll() {
        return this.termRepository.findAll();
    }

    public Term findBy(String id) {
        return this.termRepository.findOne(id);
    }

    public long countDocuments() {
        return this.termRepository.count();
    }
}
