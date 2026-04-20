package br.edu.agendacrudmysql.service;

import br.edu.agendacrudmysql.dao.ContatoDAO;
import br.edu.agendacrudmysql.model.Contato;
import java.sql.SQLException;
import java.util.List;

/**
 * SERVICE: regras de negócio + validações. Mantém Controller/View mais limpos e
 * centraliza decisões do domínio.
 */
public class ContatoService {

    private final ContatoDAO dao = new ContatoDAO();

    public int criar(Contato c) throws SQLException {
        validar(c);
        return dao.inserir(c);
    }

    public boolean atualizar(Contato c) throws SQLException {
        if (c.getId() == null) {
            throw new IllegalArgumentException("Contato sem ID não pode ser atualizado.");
}
validar(c);
        return dao.atualizar(c);
    }

    public boolean remover(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        return dao.removerPorId(id);
    }

    public Contato buscar(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        return dao.buscarPorId(id);
    }

    public List<Contato> listar() throws SQLException {
        return dao.listarTodos();
    }

    public List<Contato> buscarPorNome(String trecho) throws SQLException {
        if (trecho == null) {
            trecho = "";
        }
        return dao.buscarPorNome(trecho.trim());
    }

    private void validar(Contato c) {
        if (c.getNome() == null || c.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (c.getEmail() == null || c.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório.");
        }
        if (!c.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email inválido (faltando @).");
        }
        if (c.getTelefone() == null || c.getTelefone().trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório.");
        }
    }
}