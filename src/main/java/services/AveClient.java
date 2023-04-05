package services;

import entities.Ave;
import interfaces.Operations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utilities.AdapterJPA;

import java.util.List;

public class AveClient implements Operations<Ave> {
    private final EntityManager em = AdapterJPA.getEntityManagerFactory();

    @Override
    public List<Ave> findAll() {
        TypedQuery<Ave> query = em.createQuery("SELECT c FROM Ave c", Ave.class);
        return query.getResultList();
    }

    @Override
    public Ave findById(int id) {
        return em.find(Ave.class, id);
    }

    @Override
    public void save(Ave ave) {
        em.getTransaction().begin();
        em.persist(ave);
        em.getTransaction().commit();
    }

    @Override
    public void update(Ave ave) {
        em.getTransaction().begin();
        em.merge(ave);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Ave ave = em.find(Ave.class, id);
        em.remove(ave);
        em.getTransaction().commit();
    }
}
