package com.myproject.model;

/*
    MODEL: É o modelo no qual o projeto se baseia e vai se construir. Aqui terá
as nossas classes, objetos, dados encapsulados, método construtor e os getters e
setters, uma vez que os parâmetros serão privados.
*/

public abstract class ReservasModel {
    private int id, id_cliente;
    private String nome_cliente, doc_cliente, inicio_res, fim_res;
    private float valor_res;
    

    //Método construtor vazio => Vai ser preenchido com os dados!
    public ReservasModel(){
    }
    
//==============================================================================
    
    /*Método construtor somente com String => ReservasService vai requerer tal
    devido à validação que deverá ser feita, ou seja, essas Strings não poderão
    estar VAZIAS (Regra de Negócio)*/
    
    public ReservasModel(String nome_cliente, String doc_cliente,
                         String inicio_res, String fim_res) {
        
        this.nome_cliente = nome_cliente;
        this.doc_cliente = doc_cliente;
        this.inicio_res = inicio_res;
        this.fim_res = fim_res;
    }
        
//==============================================================================
    
    //Método construtor completo:

    public ReservasModel(int id, int id_cliente, String nome_cliente, 
                         String doc_cliente, String inicio_res, String fim_res, 
                         float valor_res) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.doc_cliente = doc_cliente;
        this.inicio_res = inicio_res;
        this.fim_res = fim_res;
        this.valor_res = valor_res;
    }
    
//==============================================================================    
    
        //Getters and Setters:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getInicio_res() {
        return inicio_res;
    }

    public void setInicio_res(String inicio_res) {
        this.inicio_res = inicio_res;
    }

    public String getFim_res() {
        return fim_res;
    }

    public void setFim_res(String fim_res) {
        this.fim_res = fim_res;
    }

    public float getValor_res() {
        return valor_res;
    }

    public void setValor_res(float valor_res) {
        this.valor_res = valor_res;
    }

    
    
}
