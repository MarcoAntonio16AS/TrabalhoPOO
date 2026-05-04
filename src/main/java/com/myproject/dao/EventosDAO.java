package com.myproject.dao;

import com.myproject.model.EventosReserva;
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

public class EventosDAO {

//==============================================================================
    //Comando que vai ser rodado no script SQL => Inserir Eventos
    public void inserir(EventosReserva evento){

        //String com o comando que vai ser colocado no SQL
        String sql = "INSERT INTO eventos_reserva "
                + "(id_reserva, tipo_evento, "
                + "data_evento, descricao) "
                + "VALUES (?, ?, ?, ?)";

        //Conexão com o banco de dados
        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
           ) {

            //Passando os dados/parâmetros
            stmt.setInt(1, evento.getId_reserva());
            stmt.setString(2, evento.getTipo_evento());
            stmt.setTimestamp(3,
                    Timestamp.valueOf(evento.getData_evento()));
            stmt.setString(4, evento.getDescricao());

            //Atualizando os dados da tabela:
            stmt.executeUpdate();

            //Caso tudo dê certo:
            System.out.println("Evento registrado!");

        //Caso algo dê errado:    
        } catch(SQLException e){
            System.out.println("Erro ao registrar evento: "+ e.getMessage());
        }

    }

//==============================================================================
    //Comando que vai ser rodado no script SQL => Listar Eventos
    public List<EventosReserva> listar(){

        List<EventosReserva> lista = new ArrayList<>();

        String sql = "SELECT * FROM eventos_reserva";

        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while(rs.next()){

                EventosReserva e = new EventosReserva();

                e.setId_evento(
                        rs.getInt("id_evento"));

                e.setId_reserva(
                        rs.getInt("id_reserva"));

                e.setTipo_evento(
                        rs.getString("tipo_evento"));

                e.setData_evento(
                        rs.getTimestamp("data_evento")
                        .toLocalDateTime());

                e.setDescricao(
                        rs.getString("descricao"));

                lista.add(e);

            }

        } catch(SQLException e){

            System.out.println(
                    "Erro ao listar eventos: "
                    + e.getMessage());

        }

        return lista;
    }

//==============================================================================
    //Comando que vai ser rodado no script SQL => Deletar Eventos
    public void deletar(int id_evento){

        String sql =
                "DELETE FROM eventos_reserva "
                + "WHERE id_evento = ?";

        try(
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id_evento);

            stmt.executeUpdate();

            System.out.println("Evento deletado!");

        } catch(SQLException e){

            System.out.println(
                    "Erro ao deletar evento: "
                    + e.getMessage());

        }

    }

}