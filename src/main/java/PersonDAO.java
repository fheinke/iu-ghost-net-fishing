import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.util.List;

@Named
@ApplicationScoped
public class PersonDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostnetPU");

    public List<Person> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Person p");
        List<Person> allPeople = query.getResultList();
        entityManager.close();
        return allPeople;
    }

    public Person findById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.id = :id");
        query.setParameter("id", id);
        Person person = (Person) query.getSingleResult();
        entityManager.close();
        return person;
    }
}
