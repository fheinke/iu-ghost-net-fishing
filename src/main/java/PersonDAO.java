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

    public void save(Person person) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(person);
        transaction.commit();
        entityManager.close();
    }
}
