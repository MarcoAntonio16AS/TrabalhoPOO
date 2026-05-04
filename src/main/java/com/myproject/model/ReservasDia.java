package com.myproject.model;
import java.time.LocalDateTime;

//Classe filha ReservasHora => Reserva para salas de Coworking!

public class ReservasDia extends ReservasModel {
    
//Atributos próprios da classe filha:
    private int num_quarto;
    private int qtd_hospedes;
    
//==============================================================================
    
    //Método construtor prórpio da classe filha + atributos da do pai!
    public ReservasDia(int id_reserva, int id_cliente, int id_recurso, 
                        LocalDateTime inicio_reserva, String status_reserva,
                        LocalDateTime fim_reserva, float total_reserva,
                        int num_quarto, int qtd_hospedes) {
        
        //Fazendo herança completa
        super(id_reserva, id_cliente, id_recurso, inicio_reserva,
              status_reserva, fim_reserva, total_reserva); 
        
        this.num_quarto = num_quarto;
        this.qtd_hospedes = qtd_hospedes;
    }
    
    //Getters and Setters da classe filha
    public int getNum_quarto() {
        return num_quarto;
    }

    public void setNum_quarto(int num_quarto) {
        this.num_quarto = num_quarto;
    }

    public int getQtd_Hospedes() {
        return qtd_hospedes;
    }

    public void setQtd_Hospedes(int qtd_hospedes) {
        this.qtd_hospedes = qtd_hospedes;
    }
    
//==============================================================================

    @Override
    public String toString(){
        return "Reserva Hotelaria:{"
                + "\nID_reserva = " + getId_reserva()
                + "\nID_cliente = " + getId_cliente()
                + "\nID_recurso = " + getId_recurso()
                + "\nStatus = " + getStatus_reserva()
                + "\nNúmero do Quarto = " + getNum_quarto()
                + "\nQtd. Hospedes = " + getQtd_Hospedes()
                + "\nPrazo de Início = " + getInicio_reserva()
                + "\nPrazo de Término = " + getFim_reserva()
                + "\nValor Total = " + getTotal_reserva()
                + "}" ;
                
    }
    
    //Como os atributos são privados, necessita que seja usado o método get.
    
}