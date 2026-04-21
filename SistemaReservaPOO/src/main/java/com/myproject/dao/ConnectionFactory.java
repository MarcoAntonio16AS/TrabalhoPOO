package com.myproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Aqui é onde ocorrerá a criação da conexão entre o Projeto em JAVA, e o 
Banco de Dados MySQL o qual será utilizado. Para isso já foi definido e
adicionado ao .xml o conector Java(mysql-connector-j).

    Para a criação dessa conexão, será adicionado o nome do Banco de Dados,
a porta, usuário e senha.
 */

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_reserva";
    
    private static final String USER = "root";
    private static final String PASSWORD = "sua_senha_aqui";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
