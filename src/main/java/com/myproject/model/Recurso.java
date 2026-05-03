package com.myproject.model;

    /*Criação de uma classe de quais são os recursos que estão disponíveis para 
    serem alugados. Uma classe direta e simples sem herança, mas que apresenta
    tipo, para justamente diversificar as opções de escolha */

public class Recurso {
    private String nome, tipo;
    private int id, capacidade;
    private boolean disponivel;
    
//==============================================================================
    
    //Método construtor vazio para obtenção de dados
    
    public Recurso(){
    }
    
//==============================================================================
    
    //Método construtor completo:
    
    public Recurso(String nome, String tipo, int id, 
                   int capacidade, boolean disponivel) {
        
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
    }
    
//==============================================================================
    
    //Getters and Setters:

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
}
