package com.myproject.model;

/*
    MODEL: É o modelo no qual o projeto se baseia e vai se construir. Aqui terá
as nossas classes, objetos, dados encapsulados, método construtor e os getters e
setters, uma vez que os parâmetros serão privados.
*/

public class ReservasModel {
    private int id;
    private String nome;

    //Método construtor vazio => Vai ser preenchido com os dados!
    public ReservasModel(){
    }
    
    //Método construtor somente com String => Já que a camada ReservasService
    //neste teste, exige!
    public ReservasModel(String nome){
        this.nome = nome;
    }
    
    //Método construtor completo
    public ReservasModel(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
