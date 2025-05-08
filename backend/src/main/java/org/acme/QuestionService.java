package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class QuestionService {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Inject
    EntityManager em;

    public List<Question> getQuestions() {
        logger.info("[DB-service] Getting all question from the DB...");
        return em.createQuery("SELECT q from Question q", Question.class).getResultList();
    }

    @Transactional(REQUIRED)
    public Question getQuestion(long id) {
        logger.info("[DB-service] Getting question with id " + id + "...");
        return em.createQuery("SELECT q from Question q WHERE q.id = :id", Question.class).setParameter("id", id).getSingleResult();
    }

    public Long countQuestions() {
        logger.info("[DB-service] Getting the total number of questions in the db...");
        TypedQuery<Long> countQuery = em.createQuery("SELECT COUNT(q) from Question q", Long.class);
        Long questionsCount = countQuery.getSingleResult();
        if (questionsCount == 0) {
            logger.info("No questions in the db...");
        }
        return questionsCount;
    }

    @Transactional(REQUIRED)
    public Question insertQuestion(Question question) {
        logger.info("[DB-service] Trying to add a question to the database...");
        em.persist(question);
        logger.info("[DB-service] Question added to the db: " + question.text);
        return question;
    }

    public Long countLessons() {
        logger.info("[DB-service] Getting the total number of lessons in the db...");
        TypedQuery<Long> countLessonsQuery = em.createQuery("SELECT COUNT(distinct q.lesson) FROM Question q", Long.class);
        Long lessonsCount = countLessonsQuery.getSingleResult();
        if (lessonsCount == 0) {
            logger.info("No lessons in the questions db...");
        }
        return lessonsCount;
    }
}
