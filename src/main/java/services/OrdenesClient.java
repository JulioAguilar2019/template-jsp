package services;

import entities.OrdenesEntity;
import interfaces.Operations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utilities.AdapterJPA;

import java.util.List;

public class OrdenesClient implements Operations<OrdenesEntity> {
    private final EntityManager em = AdapterJPA.getEntityManagerFactory();

    @Override
    public List<OrdenesEntity> findAll() {
        TypedQuery<OrdenesEntity> query = em.createQuery("SELECT c FROM OrdenesEntity c", OrdenesEntity.class);
        return query.getResultList();
    }

    @Override
    public OrdenesEntity findById(int id) {
        return em.find(OrdenesEntity.class, id);
    }

    @Override
    public void save(OrdenesEntity ordenesEntity) {
        em.getTransaction().begin();
        em.persist(ordenesEntity);
        em.getTransaction().commit();
    }

    @Override
    public void update(OrdenesEntity ordenesEntity) {
        em.getTransaction().begin();
        em.merge(ordenesEntity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        OrdenesEntity ordenesEntity = em.find(OrdenesEntity.class, id);
        em.remove(ordenesEntity);
        em.getTransaction().commit();
    }
}
