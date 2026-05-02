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
    //Não é necessário colocar novamente o método construtor + encapsulamento +
    //getter e setter, isso devido á camada Model (onde já existe isso) estar
    //inserida. Logo resta apenas fazer o resto dos comandos do banco de dados
    
    public void inserir(ReservasModel Reserva){
        
        String sql = "INSERT into Reserva(nome) VALUES (?)";
        
        try(
                Connection conn = ConnectionFactory.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
            )   {
            
            stmt.setString(1, Reserva.getNome());
            stmt.executeUpdate();
            System.out.println("Reserva realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir " + e.getMessage());
        }
    }
    
    public List<ReservasModel> Listar() {
        
        List<ReservasModel> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Reserva";
        
        try(
                Connection conn = ConnectionFactory.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
            )   {
            
            while(rs.next()) {
                
                ReservasModel r = new ReservasModel();
                
                r.setId(rs.getInt("id"));
                r.setNome(rs.getString("nome"));
                
                lista.add(r);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        
        return lista; 
    }
    
}
