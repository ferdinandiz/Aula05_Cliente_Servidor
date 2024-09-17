package com.clienteservidor.dao;

import com.clienteservidor.model.Alunos;
import com.clienteservidor.model.Cursos;

import java.util.List;
import java.util.Optional;

public interface IAlunoDAO {

    Alunos create(Alunos aluno);

    void update(Alunos aluno);

    void delete(Alunos aluno);

    Optional<Alunos> findById(Long id);

    List<Alunos> findAll();

    List<Alunos> findByCurso(Cursos curso);
}
