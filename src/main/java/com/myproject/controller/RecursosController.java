package com.myproject.controller;

import com.myproject.model.Recurso;
import com.myproject.service.RecursosService;
import java.util.List;

/*
    CONTROLLER: Responsável por gerir e administrar o fluxo de comandos entre 
a View e o Service, servindo como uma camada intermediária a qual recebe os
dados da View, chama o Service, e depois retorna os dados para a View.

*/

public class RecursosController {

    private final RecursosService service =
            new RecursosService();

    //==========================================================================
    // CRIAR RECURSO

    public void criarRecurso(
            String nome,
            String tipo,
            int capacidade,
            float preco,
            boolean disponivel
    ) {

        service.criarRecurso(
                nome,
                tipo,
                capacidade,
                preco,
                disponivel
        );

    }

//==============================================================================
    // LISTAR RECURSOS

    public List<Recurso> listarRecursos() {
        return service.listarRecursos();
    }

//==============================================================================
    // ATUALIZAR RECURSO

    public void atualizarRecurso(
            int id,
            String nome,
            String tipo,
            int capacidade,
            float preco,
            boolean disponivel
    ) {

        service.atualizarRecurso(
                id,
                nome,
                tipo,
                capacidade,
                preco,
                disponivel
        );

    }

//==============================================================================
    // ALTERAR DISPONIBILIDADE

    public void alterarDisponibilidade(
            int id,
            boolean disponivel
    ) {

        service.alterarDisponibilidade(
                id,
                disponivel
        );

    }

//==============================================================================
    // DELETAR RECURSO

    public void deletarRecurso(int id) {
        service.deletarRecurso(id);
    }

}