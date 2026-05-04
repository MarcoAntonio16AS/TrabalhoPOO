package com.myproject.dao;

import com.myproject.model.Recurso; //Sempre importar a entidade do DAO.
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
    DAO: Camada responsável pelo acesso aos dados presentes dentro do Banco de 
dados o qual será utilizado. Enquanto o "ConnectionFactory" cria a conexão entre 
o db e o projeto, centralizando tudo em uma file apenas; o DAO tem como objetivo
acessar esses dados e criar modificações diretamente dentro do banco, em suas
tabelas e em seus dados. Seja inserir, deletar, ou selecionar.

*/

//==============================================================================

public class RecursosDAO {
    
    //Comando que vai ser rodado no script SQL => Inserir Recursos
    public void inserir(Recurso recurso){
        String sql = "INSERT into recursos"
                + "(nome_recurso, tipo_recurso, cap_recurso, "
                + "preco_recurso, disponivel) "
                + "VALUES (?, ?, ?, ?, ?)";
        
        //Conexão com o banco de dados + preparação
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
            )   {
            
                    //String que adiciona os valores
                    stmt.setString(1, recurso.getNome_recurso());
                    stmt.setString(2, recurso.getTipo_recurso());
                    stmt.setInt(3, recurso.getCap_recurso());
                    stmt.setFloat(4, recurso.getPreco_recurso());
                    stmt.setBoolean(5, recurso.isDisponivel());
                    
                    //Executar comando
                    stmt.executeUpdate();
                    
                    //Resultado que deve aparecer na tela ser tudo ocorrer bem!
                    System.out.println("Recurso inserido com sucesso!");
                
                //Caso dê algum erro, isso sairá na tela!
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir " + e.getMessage());
                }
        
    }
    
//==============================================================================    
    
    //Comando que vai ser rodado no script SQl => Listar Recursos
    public List<Recurso> listar(){
        
        //Criando nova ArrayList
        List<Recurso> lista = new ArrayList<> ();
        
        //String de comando do SQL
        String sql = "SELECT * FROM recursos";
        
        //Conexão com o banco de dados + preparação
        try(
                Connection conn = ConnectionFactory.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
            )   {
            
                //Coletando as informações da tabela e adicionando a lista
                while(rs.next()) {
                
                    Recurso r = new Recurso();
                
                    r.setId_recurso(rs.getInt("id_recurso"));
                    r.setNome_recurso(rs.getString("nome_recurso"));
                    r.setTipo_recurso(rs.getString("tipo_recurso"));
                    r.setCap_recurso(rs.getInt("cap_recurso"));
                    r.setPreco_recurso(rs.getFloat("preco_recurso"));
                    r.setDisponivel(rs.getBoolean("disponivel"));
                
                    lista.add(r);
            }
            
        //Caso haja erro, mostrar a seguinte mensagem do sql        
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        
        //Devolvendo a lista criada
        return lista; 
    }
    
//==============================================================================
    
    //Comando que vai ser rodado no script SQL => Atualizar Recursos
    //O WHERE É DE SUMA IMPORTÂNCIA, SE NÃO APAGA TUDO!!!!
    public void atualizar(Recurso recurso){
        String sql = "UPDATE recursos " +
                "SET nome_recurso = ?, " +
                "tipo_recurso = ?, " +
                "cap_recurso = ?, " +
                "preco_recurso = ?, " +
                "disponivel = ? " +
                "WHERE id_recurso = ?";
                
        //Testando a conexão com o banco
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
                
                //String para passar os valores/parâmetros
                stmt.setString(1, recurso.getNome_recurso());
                stmt.setString(2, recurso.getTipo_recurso());
                stmt.setInt(3, recurso.getCap_recurso());
                stmt.setFloat(4, recurso.getPreco_recurso());
                stmt.setBoolean(5, recurso.isDisponivel());
                stmt.setInt(6, recurso.getId_recurso());
            
                //Executar comando
                stmt.executeUpdate();
                
                //Se tudo ocorrer bem, mensagem à aparecer:
                System.out.println("Atualização realizada com sucesso!");
                
            //Se surgir algum erro:    
            } catch(SQLException e) {
                System.out.println("Não foi possível atualizar: " 
                                    + e.getMessage());
            }
        
    }
    
//==============================================================================
    
    //Comando que vai ser rodado no script SQL => Deletar/Apagar Recursos
    //O WHERE É DE SUMA IMPORTÂNCIA, SE NÃO APAGA TUDO!!!!
    public void deletar(int id_recurso){
        String sql = "DELETE FROM recursos WHERE id_recurso = ?";
        
        //Testando a conexão com o banco
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
            
                //String que passa os valores/parâmetros
                stmt.setInt(1, id_recurso);
                
                //Executar comando
                stmt.executeUpdate();
                
                //Se tudo ocorrer corretamente deverá aparecer:
                System.out.println("Recurso excluído com sucesso!");
                
            } catch(SQLException e) {
                System.out.println("Erro ao excluir: " + e.getMessage());
            } 
        
    }
    
}