package com.clienteservidor.dao;

import com.clienteservidor.model.Alunos;
import com.clienteservidor.model.Cursos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class AlunosDAO implements IAlunoDAO{

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cliente_servidorPU");

    @Override
    public Alunos create(Alunos aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return aluno;
    }

    @Override
    public void update(Alunos aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    @Override
    public void delete(Alunos aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(aluno);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    @Override
    public Optional<Alunos> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return Optional.ofNullable(
                em.find(Alunos.class, id)
            );
        }finally {
            em.close();
        }
    }

    @Override
    public List<Alunos> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Alunos a", Alunos.class).getResultList();
        } finally {
            em.close();
        }
    }


    @Override
    public List<Alunos> findByCurso(Cursos curso) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Alunos a WHERE a.curso = :curso", Alunos.class)
                    .setParameter("curso", curso)
                    .getResultList();

        }finally {
            em.close();
        }
    }
}
