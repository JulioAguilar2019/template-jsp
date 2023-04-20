package services;

//import entities.Ave;
//import entities.Estudiante;
import entities.Estudiante;
import interfaces.Operations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utilities.AdapterJPA;

import java.util.List;

public class EstudianteClient implements Operations<Estudiante> {
    private final EntityManager em = AdapterJPA.getEntityManagerFactory();

    @Override
    public List<Estudiante> findAll() {
        TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e LEFT JOIN FETCH e.cursos", Estudiante.class);
        return query.getResultList();
    }

    @Override
    public Estudiante findById(int id) {
        return em.find(Estudiante.class, id);
    }

    @Override
    public void save(Estudiante estudiante) {
        em.getTransaction().begin();
        em.persist(estudiante);
        em.getTransaction().commit();
    }

    @Override
    public void update(Estudiante estudiante) {
        em.getTransaction().begin();
        em.merge(estudiante);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Estudiante estudiante = em.find(Estudiante.class, id);
        em.remove(estudiante);
        em.getTransaction().commit();
    }
}
