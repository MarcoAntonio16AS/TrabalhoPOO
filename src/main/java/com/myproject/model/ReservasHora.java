package com.myproject.model;

//Classe filha ReservasHora => Reserva para salas de Coworking!

public class ReservasHora extends ReservasModel {
    
//Atributos próprios da classe filha:
    private int sala;
    private int qtd_pessoas;
    
//==============================================================================
    
    //Método construtor prórpio da classe filha + atributos da do pai!
    public ReservasHora(int id, int id_cliente, String nome_cliente, 
                        String doc_cliente, String inicio_res, String fim_res, 
                        float valor_res, int sala, int qtd_pessoas) {
        
        super(id, id_cliente, nome_cliente, doc_cliente, 
              inicio_res, fim_res, valor_res); //Fazendo herança completa
        
        this.sala = sala;
        this.qtd_pessoas = qtd_pessoas;
    }
    
    //Getters and Setters da classe filha
    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getQtd_Pessoas() {
        return qtd_pessoas;
    }

    public void setQtd_Pessoas(int qtd_pessoas) {
        this.qtd_pessoas = qtd_pessoas;
    }
    
//==============================================================================

    @Override
    public String toString(){
        return "Reserva Coworking:{"
                + "\nID = " + getId()
                + "\nID_cliente = " + getId_cliente()
                + "\nNome_cliente = " + getNome_cliente()
                + "\nDocumento_cliente = " + getDoc_cliente()
                + "\nNúmero da Sala = " + getSala()
                + "\nQtd. Pessoas = " + getQtd_Pessoas()
                + "\nPrazo de Início = " + getInicio_res()
                + "\nPrazo de Término = " + getFim_res()
                + "\nValor = " + getValor_res()
                + "}" ;
                
    }
    
    //Como os atributos são privados, necessita que seja usado o método get.
    
}