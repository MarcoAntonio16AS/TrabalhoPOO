package com.myproject.model;

    /*Criação de uma classe de quais são os recursos que estão disponíveis para 
    serem alugados. Uma classe direta e simples sem herança, mas que apresenta
    tipo, para justamente diversificar as opções de escolha */

public class Recurso {
    private String nome_recurso, tipo_recurso;
    private int id_recurso, cap_recurso;
    private float preco_recurso;
    private boolean disponivel;
    
//==============================================================================
    
    //Método construtor vazio para obtenção de dados
    
    public Recurso(){
    }
    
//==============================================================================
    
    //Método construtor completo:
    
    public Recurso(String nome_recurso, String tipo_recurso, int id_recurso, 
                   float preco_recurso, int cap_recurso, boolean disponivel) {
        
        this.id_recurso = id_recurso;
        this.nome_recurso = nome_recurso;
        this.tipo_recurso = tipo_recurso;
        this.cap_recurso = cap_recurso;
        this.preco_recurso = preco_recurso;
        this.disponivel = disponivel;
    }
    
//==============================================================================
    
    //Getters and Setters:

    public String getNome_recurso() {
        return nome_recurso;
    }

    public void setNome_recurso(String nome_recurso) {
        this.nome_recurso = nome_recurso;
    }

    public String getTipo_recurso() {
        return tipo_recurso;
    }

    public void setTipo_recurso(String tipo_recurso) {
        this.tipo_recurso = tipo_recurso;
    }

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public int getCap_recurso() {
        return cap_recurso;
    }

    public void setCap_recurso(int cap_recurso) {
        this.cap_recurso = cap_recurso;
    }

    public float getPreco_recurso() {
        return preco_recurso;
    }

    public void setPreco_recurso(float preco_recurso) {
        this.preco_recurso = preco_recurso;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    
    
}
