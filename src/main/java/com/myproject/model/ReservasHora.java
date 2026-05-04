package com.myproject.model;
import java.time.LocalDateTime;

//Classe filha ReservasHora => Reserva para salas de Coworking!

public class ReservasHora extends ReservasModel {
    
//Atributos próprios da classe filha:
    private int sala;
    private int qtd_pessoas;
    
//==============================================================================
    
    //Método construtor prórpio da classe filha + atributos da do pai!
    public ReservasHora(int id_reserva, int id_cliente, int id_recurso, 
                        LocalDateTime inicio_reserva, String status_reserva,
                        LocalDateTime fim_reserva, float total_reserva,
                        int sala, int qtd_pessoas) {
        
        //Fazendo herança completa
        super(id_reserva, id_cliente, id_recurso, inicio_reserva,
              status_reserva, fim_reserva, total_reserva); 
        
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
                + "\nID_reserva = " + getId_reserva()
                + "\nID_cliente = " + getId_cliente()
                + "\nID_recurso = " + getId_recurso()
                + "\nStatus = " + getStatus_reserva()
                + "\nNúmero da Sala = " + getSala()
                + "\nQtd. Pessoas = " + getQtd_Pessoas()
                + "\nPrazo de Início = " + getInicio_reserva()
                + "\nPrazo de Término = " + getFim_reserva()
                + "\nValor Total = " + getTotal_reserva()
                + "}" ;
                
    }
    
    //Como os atributos são privados, necessita que seja usado o método get.
    
}