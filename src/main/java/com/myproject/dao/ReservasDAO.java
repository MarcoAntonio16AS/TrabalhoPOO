package com.myproject.dao;

import com.myproject.model.ReservasModel;
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

public class ReservasDAO {

    //==========================================================================
    //Comando que vai ser rodado no script SQL => Inserir Reservas
    public void inserir(ReservasModel reserva){

        //Comando a ser digitado no SQL
        String sql = "INSERT INTO reservas "
                + "(id_cliente, id_recurso, inicio_reserva, "
                + "fim_reserva, total_reserva, status_reserva) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        //Conexão com o banco
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            //Enviando dados/parâmetros
            stmt.setInt(1, reserva.getId_cliente());
            stmt.setInt(2, reserva.getId_recurso());
            stmt.setTimestamp(3,
                    Timestamp.valueOf(reserva.getInicio_reserva()));
            stmt.setTimestamp(4,
                    Timestamp.valueOf(reserva.getFim_reserva()));
            stmt.setFloat(5, reserva.getTotal_reserva());
            stmt.setString(6, reserva.getStatus_reserva());

            //Atualizando a tabela
            stmt.executeUpdate();

            //Se tudo ocorrer corretamente:
            System.out.println("Reserva criada com sucesso!");

        //Caso algo dê errado:    
        } catch(SQLException e){
            System.out.println("Erro ao inserir reserva: " + e.getMessage());
        }

    }

    //==========================================================================
    //Comando que vai ser rodado no script SQL => Listar Reservas
    public List<ReservasModel> listar(){

        List<ReservasModel> lista = new ArrayList<>();

        //String a ser usada como comando no SQL
        String sql = "SELECT * FROM reservas";

        //Conexão com banco de dados
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            
            //Puxando dados das tabelas e adicionando à uma lista
            while(rs.next()){

                ReservasModel r = new ReservasModel();

                r.setId_reserva(rs.getInt("id_reserva"));
                r.setId_cliente(rs.getInt("id_cliente"));
                r.setId_recurso(rs.getInt("id_recurso"));

                r.setInicio_reserva(
                        rs.getTimestamp("inicio_reserva")
                        .toLocalDateTime());

                r.setFim_reserva(
                        rs.getTimestamp("fim_reserva")
                        .toLocalDateTime());

                r.setTotal_reserva(
                        rs.getFloat("total_reserva"));

                r.setStatus_reserva(
                        rs.getString("status_reserva"));

                lista.add(r);
  
            }
        
        //Caso algo dê errado:
        } catch(SQLException e){
            System.out.println("Erro ao listar reservas: " + e.getMessage());
        }

        return lista;
        //Fazer a lista aparecer
        
    }

    //==========================================================================
    //Comando que vai ser rodado no script SQL => Atualizar Reservas
    public void atualizar(ReservasModel reserva){

        //String que será posta como comando no SQL
        String sql = "UPDATE reservas "
                + "SET id_cliente = ?, "
                + "id_recurso = ?, "
                + "inicio_reserva = ?, "
                + "fim_reserva = ?, "
                + "total_reserva = ?, "
                + "status_reserva = ? "
                + "WHERE id_reserva = ?";

        //Conectar ao banco de dados
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
           ) {

            stmt.setInt(1, reserva.getId_cliente());
            stmt.setInt(2, reserva.getId_recurso());
            stmt.setTimestamp(3,
                    Timestamp.valueOf(reserva.getInicio_reserva()));
            stmt.setTimestamp(4,
                    Timestamp.valueOf(reserva.getFim_reserva()));
            stmt.setDouble(5, reserva.getTotal_reserva());
            stmt.setString(6, reserva.getStatus_reserva());
            stmt.setInt(7, reserva.getId_reserva());

            //Atualizar os dados da tabela
            stmt.executeUpdate();

            //Caso tudo dê certo:
            System.out.println("Reserva atualizada!");

        //Caso algo dê errado:
        } catch(SQLException e){
            System.out.println("Erro ao atualizar reserva: " + e.getMessage());
        }

    }

    //==========================================================================
    // Comando que vai ser rodado script SQL => Deletar/Apagar Reserva
    public void deletar(int id_reserva){
        
        //String com comando que vai para o banco
        String sql = "DELETE FROM reservas WHERE id_reserva = ?";

        //Conectando ao banco de dados
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
           ) {
            
            //Enviando dados/parâmetros
            stmt.setInt(1, id_reserva);
            
            //Comando para atualizar
            stmt.executeUpdate();

            //Caso tudo dê certo:
            System.out.println("Reserva deletada!");

        //Caso algo dê errado:    
        } catch(SQLException e){
            System.out.println("Erro ao deletar reserva: " + e.getMessage());
        }

    }

}