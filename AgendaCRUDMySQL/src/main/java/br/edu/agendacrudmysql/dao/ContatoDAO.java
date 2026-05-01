package br.edu.agendacrudmysql.dao;

import br.edu.agendacrudmysql.model.Contato;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO: camada de acesso a dados (SQL). - Use PreparedStatement para evitar SQL
 * Injection. - Converte ResultSet em objetos Contato (mapeamento).
 */
public class ContatoDAO {

    public int inserir(Contato c) throws SQLException {
        String sql = "INSERT INTO contatos (nome, email, telefone) VALUES(?, ?, ?)";
try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelefone());
            int linhas = ps.executeUpdate();
            if (linhas == 0) {
                throw new SQLException("Inserção falhou: nenhuma linha afetada.");
}
// Recupera o ID gerado automaticamente (AUTO_INCREMENT)
try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            throw new SQLException(
            "Inserção falhou: não foi possível obter o ID gerado.");
}
}
public boolean atualizar(Contato c) throws SQLException {
        String sql = "UPDATE contatos SET nome=?, email=?, telefone=? WHEREid =  ?";
try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelefone());
            ps.setInt(4, c.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean removerPorId(int id) throws SQLException {
        String sql = "DELETE FROM contatos WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public Contato buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, nome, email, telefone FROM contatos WHEREid =  ?";
try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapContato(rs);
                }
                return null;
            }
        }
    }

    public List<Contato> listarTodos() throws SQLException {
        String sql = "SELECT id, nome, email, telefone FROM contatos ORDER BYid";
List<Contato> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapContato(rs));
            }
        }
        return lista;
    }

    public List<Contato> buscarPorNome(String trecho) throws SQLException {
        String sql = "SELECT id, nome, email, telefone FROM contatos WHERE nomeLIKE ? ORDER  BY nome";
List<Contato> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + trecho + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapContato(rs));
                }
            }
        }
        return lista;
    }

    private Contato mapContato(ResultSet rs) throws SQLException {
        return new Contato(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone")
        );
    }
}
