package com.myproject.controller;

import com.myproject.model.Cliente;
import com.myproject.service.ClientesService;
import java.util.List;

/*
    CONTROLLER: Responsável por gerir e administrar o fluxo de comandos entre 
a View e o Service, servindo como uma camada intermediária a qual recebe os
dados da View, chama o Service, e depois retorna os dados para a View.

*/

public class ClientesController {

    private final ClientesService service =
            new ClientesService();

//==============================================================================
    // CRIAR CLIENTE

    public void criarCliente(
            String nome,
            String documento,
            String telefone
    ) {

        service.criarCliente(
                nome,
                documento,
                telefone
        );

    }

//==============================================================================
    // LISTAR CLIENTES

    public List<Cliente> listarClientes() {
        return service.listarClientes();
    }

//==============================================================================
    // ATUALIZAR CLIENTE

    public void atualizarCliente(
            int id,
            String nome,
            String documento,
            String telefone
    ) {

        service.atualizarCliente(
                id,
                nome,
                documento,
                telefone
        );

    }

//==============================================================================
    // DELETAR CLIENTE

    public void deletarCliente(int id) {
        service.deletarCliente(id);
    }

}
