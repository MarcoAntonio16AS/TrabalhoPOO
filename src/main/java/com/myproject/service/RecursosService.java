package com.myproject.service;

import com.myproject.dao.RecursosDAO;
import com.myproject.model.Recurso;
import java.util.List;

/*
    SERVICE: Aqui é onde estarão as regras de negócio e possíveis cálculos
necessários durante o decorrer do projeto. Também constará as validações 
necessárias para o Controller e a View manterem-se mais limpas e agrupar todas
as decisões de negócio em apenas um local.

*/

public class RecursosService {

    private final RecursosDAO dao = new RecursosDAO();

//==============================================================================
    // CRIAR RECURSO

    public void criarRecurso(
            String nome,
            String tipo,
            int capacidade,
            float preco,
            boolean disponivel
    ) {

        // Validações
        if(nome == null || nome.isBlank()) {

            System.out.println("Nome inválido!");
            return;
        }

        if(capacidade <= 0) {

            System.out.println("Capacidade inválida!");
            return;
        }

        if(preco <= 0) {

            System.out.println("Preço inválido!");
            return;
        }

        Recurso recurso = new Recurso();

        recurso.setNome_recurso(nome);
        recurso.setTipo_recurso(tipo);
        recurso.setCap_recurso(capacidade);
        recurso.setPreco_recurso(preco);
        recurso.setDisponivel(disponivel);

        dao.inserir(recurso);
    }

//==============================================================================
    // LISTAR RECURSOS

    public List<Recurso> listarRecursos() {
        return dao.listar();
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

        Recurso recurso = new Recurso();

        recurso.setId_recurso(id);
        recurso.setNome_recurso(nome);
        recurso.setTipo_recurso(tipo);
        recurso.setCap_recurso(capacidade);
        recurso.setPreco_recurso(preco);
        recurso.setDisponivel(disponivel);

        dao.atualizar(recurso);
    }

//==============================================================================
    // DELETAR RECURSO

    public void deletarRecurso(int id) {
        dao.deletar(id);
    }

//==============================================================================
    // ALTERAR DISPONIBILIDADE

    public void alterarDisponibilidade(
            int id,
            boolean disponivel
    ) {

        List<Recurso> lista = dao.listar();

        for(Recurso r : lista) {

            if(r.getId_recurso() == id) {

                r.setDisponivel(disponivel);

                dao.atualizar(r);

                System.out.println("Disponibilidade atualizada!");

                return;
            }
        }
      System.out.println("Recurso não encontrado!");
    }

}