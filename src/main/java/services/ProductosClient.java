package services;

import entities.ProductosEntity;
import interfaces.Operations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utilities.AdapterJPA;

import java.util.List;

public class ProductosClient implements Operations<ProductosEntity> {
    private final EntityManager em = AdapterJPA.getEntityManagerFactory();

    @Override
    public List<ProductosEntity> findAll() {
        TypedQuery<ProductosEntity> query = em.createQuery("SELECT c FROM ProductosEntity c", ProductosEntity.class);
        return query.getResultList();
    }

    @Override
    public ProductosEntity findById(int id) {
        return em.find(ProductosEntity.class, id);
    }

    @Override
    public void save(ProductosEntity productosEntity) {
        em.getTransaction().begin();
        em.persist(productosEntity);
        em.getTransaction().commit();
    }

    @Override
    public void update(ProductosEntity productosEntity) {
        em.getTransaction().begin();
        em.merge(productosEntity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        ProductosEntity productosEntity = em.find(ProductosEntity.class, id);
        em.remove(productosEntity);
        em.getTransaction().commit();
    }
}
