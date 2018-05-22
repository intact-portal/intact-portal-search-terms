package uk.ac.ebi.intact.search.terms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.ebi.intact.search.terms.model.Term;
import uk.ac.ebi.intact.search.terms.repository.TermRepository;

import java.util.Collection;

/**
 * @author Elisabet Barrera
 */
@Service
public class TermIndexService {

    @Autowired
    @Qualifier("termRepository")
    private TermRepository termRepository;

    @Transactional
    public void deleteAll() {
        this.termRepository.deleteAll();
    }

    @Transactional
    public void save(Term term) {
        this.termRepository.save(term);
    }

    @Transactional
    public void save(Collection<Term> terms) {
        this.termRepository.save(terms);
    }

    @Transactional
    public void delete(Term id) {
        this.termRepository.delete(id);
    }
}
