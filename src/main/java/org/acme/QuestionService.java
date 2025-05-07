package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class QuestionService {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Inject
    EntityManager em;

    public List<Question> getQuestions() {
        logger.info("[GET] Getting all question from the DB...");
        return em.createQuery("SELECT q from Question q", Question.class).getResultList();
    }
}
