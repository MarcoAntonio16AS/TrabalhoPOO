package com.myproject.dao;

import com.myproject.model.Cliente; //Sempre importar a entidade do DAO.
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

public class ClientesDAO {
    
    //Comando que vai ser rodado no script SQL => Inserir Clientes
    public void inserir(Cliente cliente){
        String sql = "INSERT into clientes"
                + "(nome_cliente, doc_cliente, tel_cliente) "
                + "VALUES (?, ?, ?)";
        
        //Conexão com o banco de dados + preparação
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
            )   {
            
                    //String que adiciona os valores
                    stmt.setString(1, cliente.getNome_cliente());
                    stmt.setString(2, cliente.getDoc_cliente());
                    stmt.setString(3, cliente.getTel_cliente());
                    
                    //Executar comando
                    stmt.executeUpdate();
                    
                    //Resultado que deve aparecer na tela ser tudo ocorrer bem!
                    System.out.println("Reserva realizada com sucesso!");
                
                //Caso dê algum erro, isso sairá na tela!
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir " + e.getMessage());
                }
        
    }
    
//==============================================================================    
    
    //Comando que vai ser rodado no script SQl => Listar Clientes
    public List<Cliente> listar(){
        
        //Criando nova ArrayList
        List<Cliente> lista = new ArrayList<> ();
        
        //String de comando do SQL
        String sql = "SELECT * FROM clientes";
        
        //Conexão com o banco de dados + preparação
        try(
                Connection conn = ConnectionFactory.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
            )   {
            
                //Coletando as informações da tabela e adicionando a lista
                while(rs.next()) {
                
                    Cliente r = new Cliente();
                
                    r.setId_cliente(rs.getInt("id_cliente"));
                    r.setNome_cliente(rs.getString("nome_cliente"));
                    r.setDoc_cliente(rs.getString("doc_cliente"));
                    r.setTel_cliente(rs.getString("tel_cliente"));
                
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
    
    //Comando que vai ser rodado no script SQL => Atualizar Clientes
    //O WHERE É DE SUMA IMPORTÂNCIA, SE NÃO APAGA TUDO!!!!
    public void atualizar(Cliente cliente){
        String sql = "UPDATE clientes " +
                "SET nome_cliente = ?, " +
                "doc_cliente = ?, " +
                "tel_cliente = ? " +
                "WHERE id_cliente = ?";
                
        //Testando a conexão com o banco
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
                
                //String para passar os valores/parâmetros
                stmt.setString(1, cliente.getNome_cliente());
                stmt.setString(2, cliente.getDoc_cliente());
                stmt.setString(3, cliente.getTel_cliente());
                stmt.setInt(4, cliente.getId_cliente());
            
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
    
    //Comando que vai ser rodado no script SQL => Deletar/Apagar Clientes
    //O WHERE É DE SUMA IMPORTÂNCIA, SE NÃO APAGA TUDO!!!!
    public void deletar(int id_cliente){
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
        
        //Testando a conexão com o banco
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
            
                //String que passa os valores/parâmetros
                stmt.setInt(1, id_cliente);
                
                //Executar comando
                stmt.executeUpdate();
                
                //Se tudo ocorrer corretamente deverá aparecer:
                System.out.println("Cliente deletado com sucesso!");
                
            } catch(SQLException e) {
                System.out.println("Erro ao deletar: " + e.getMessage());
            } 
        
    }
    
}
