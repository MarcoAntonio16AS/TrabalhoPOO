package br.edu.agendacrudmysql.controller;

import br.edu.agendacrudmysql.model.Contato;
import br.edu.agendacrudmysql.service.ContatoService;
import java.sql.SQLException;
import java.util.List;

/**
 * CONTROLLER: coordena o fluxo entre View e Service. Recebe dados da View,
 * chama Service e devolve resultado para a View.
 */
public class ContatoController {

    private final ContatoService service = new ContatoService();

    public int criarContato(String nome, String email, String telefone) throws
            SQLException {
        Contato c = new Contato(nome, email, telefone);
        return service.criar(c);
    }

    public boolean atualizarContato(int id, String nome, String email, String telefone) throws SQLException {
        Contato c = new Contato(id, nome, email, telefone);
        return service.atualizar(c);
    }

    public boolean removerContato(int id) throws SQLException {
        return service.remover(id);
    }

    public Contato buscarContato(int id) throws SQLException {
        return service.buscar(id);
    }

    public List<Contato> listarContatos() throws SQLException {
        return service.listar();
    }

    public List<Contato> buscarPorNome(String trecho) throws SQLException {
        return service.buscarPorNome(trecho);
    }
}
