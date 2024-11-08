import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.util.List;

@Named
@ApplicationScoped
public class GhostnetDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostnetPU");

    public List<Ghostnet> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("SELECT g FROM Ghostnet g");
        List<Ghostnet> allGhostnets = query.getResultList();
        entityManager.close();
        return allGhostnets;
    }

    public void save(Ghostnet ghostnet) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(ghostnet);
        transaction.commit();
        entityManager.close();
    }

    public void update(Ghostnet ghostnet) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(ghostnet);
        transaction.commit();
        entityManager.close();
    }

    public void delete(Ghostnet ghostnet) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Ghostnet managedGhostnet = entityManager.contains(ghostnet) ? ghostnet : entityManager.merge(ghostnet);
        entityManager.remove(managedGhostnet);
        transaction.commit();
        entityManager.close();
    }
}
