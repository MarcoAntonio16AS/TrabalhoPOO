package com.myproject.model;

//Classe Cliente => Possuirá um registro salvo no sistema da aplicação.

public class Cliente {
    private int id_cliente;
    private String nome_cliente, doc_cliente, tel_cliente;
    
    //Criação de um construtor vazio, para que dados possam ser colocados!
    public Cliente(){    
    }
    
//==============================================================================
    
    /*Método construtor somente com String => ClienteService vai requerer tal
    devido à validação que deverá ser feita, ou seja, essas Strings não poderão
    estar VAZIAS (Regra de Negócio)*/
    
    public Cliente(String nome_cliente, String doc_cliente, String tel_cliente){
        this.nome_cliente = nome_cliente;
        this.doc_cliente = doc_cliente;
        this.tel_cliente = tel_cliente;
    }

//==============================================================================
    
    //Método construtor completo!
    
    public Cliente(String nome_cliente, String doc_cliente,
                    int id_cliente, String tel_cliente) {
        
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.doc_cliente = doc_cliente;
        this.tel_cliente = tel_cliente;
    }
    
//==============================================================================
    
    //Getters and Setters

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTel_cliente() {
        return tel_cliente;
    }

    public void setTel_cliente(String tel_cliente) {
        this.tel_cliente = tel_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getDoc_cliente() {
        return doc_cliente;
    }

    public void setDoc_cliente(String doc_cliente) {
        this.doc_cliente = doc_cliente;
    }

}
