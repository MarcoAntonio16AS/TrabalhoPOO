package com.myproject.service;

import com.myproject.dao.ClientesDAO;
import com.myproject.model.Cliente;
import java.util.List;

public class ClientesService {

/*
    SERVICE: Aqui é onde estarão as regras de negócio e possíveis cálculos
necessários durante o decorrer do projeto. Também constará as validações 
necessárias para o Controller e a View manterem-se mais limpas e agrupar todas
as decisões de negócio em apenas um local.

*/    
    
    private final ClientesDAO dao = new ClientesDAO();

//==============================================================================
    //CRIAR CLIENTE

    public void criarCliente(
            String nome,
            String documento,
            String telefone
    ) {

        // Validações
        if(nome == null || nome.isBlank()) {
            System.out.println("Nome inválido!");
            return;
        }

        if(documento == null || documento.isBlank()) {
            System.out.println("Documento inválido!");
            return;
        }

        Cliente cliente = new Cliente();

        cliente.setNome_cliente(nome);
        cliente.setDoc_cliente(documento);
        cliente.setTel_cliente(telefone);

        dao.inserir(cliente);
    }

//==============================================================================
    // LISTAR CLIENTES

    public List<Cliente> listarClientes() {
        return dao.listar();
    }

//==============================================================================
    // ATUALIZAR CLIENTE

    public void atualizarCliente(
            int id,
            String nome,
            String documento,
            String telefone
    ) {

        Cliente cliente = new Cliente();

        cliente.setId_cliente(id);
        cliente.setNome_cliente(nome);
        cliente.setDoc_cliente(documento);
        cliente.setTel_cliente(telefone);

        dao.atualizar(cliente);
    }

//==============================================================================
    // DELETAR CLIENTE

    public void deletarCliente(int id) {
        dao.deletar(id);
    }
}