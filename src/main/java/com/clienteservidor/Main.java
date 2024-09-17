package com.clienteservidor;

import com.clienteservidor.dao.AlunosDAO;
import com.clienteservidor.model.Alunos;
import com.clienteservidor.util.Funcoes;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        AlunosDAO dao = new AlunosDAO();
        Optional<Alunos> aluno = dao.findById(3L);
        if (aluno.isPresent()) {
            Funcoes.print(aluno.get());
        }

        List<Alunos> alunos = dao.findAll();
        Funcoes.printList(alunos);

    }
}