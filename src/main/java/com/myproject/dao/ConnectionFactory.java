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

    private static final String URL = "jdbc:postgresql://"
            + "ep-jolly-lab-acu2a2fy-pooler.sa-east-1.aws.neon.tech/"
            + "neondb?sslmode=require";
    
    private static final String USER = "neondb_owner";
    private static final String PASSWORD = "npg_sVqNTJ2bWg3p";

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
