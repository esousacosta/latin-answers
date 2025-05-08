package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.json.bind.annotation.JsonbProperty;


/**
 * Example JPA entity.
 *
 * To use it, get access to a JPA EntityManager via injection.
 *
 * {@code
 *     @Inject
 *     EntityManager em;
 *
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.text = "text-1";
 *         em.persist(entity1);
 *
 *         List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();
 *     }
 * }
 */
@Entity
@Table(name = "T_QUESTION")
public class Question extends PanacheEntity {
    @NotNull
    @JsonbProperty("text")
    public String text;
    @JsonbProperty("answer")
    public String answer;
    @JsonbProperty("lesson")
    public String lesson;
}
