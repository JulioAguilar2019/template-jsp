package services;

//import entities.Ave;
//import entities.Estudiante;
import entities.Curso;
import interfaces.Operations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utilities.AdapterJPA;

import java.util.List;

public class CursosClient implements Operations<Curso> {
    private final EntityManager em = AdapterJPA.getEntityManagerFactory();

    @Override
    public List<Curso> findAll() {
        TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c", Curso.class);
        return query.getResultList();
    }

    @Override
    public Curso findById(int id) {
        return em.find(Curso.class, id);
    }

    @Override
    public void save(Curso curso) {
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
    }

    @Override
    public void update(Curso curso) {
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Curso curso = em.find(Curso.class, id);
        em.remove(curso);
        em.getTransaction().commit();
    }
}
