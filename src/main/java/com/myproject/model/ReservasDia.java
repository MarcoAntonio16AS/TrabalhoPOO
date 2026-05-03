package com.myproject.model;

//Classe filha ReservasDia => Reservas para serviços de Hotelaria 

public class ReservasDia extends ReservasModel {
    
    //Atributos próprios da classe filha
    private int num_quarto;
    private int num_hospedes;
    private boolean serv_quarto; 
    
//==============================================================================
    
    //Método construtor próprio da classe filha
    public ReservasDia(int num_quarto, int num_hospedes, boolean serv_quarto,
                       int id, int id_cliente, String nome_cliente, 
                       String doc_cliente, String inicio_res, String fim_res, 
                       float valor_res){
        
        super(id, id_cliente, nome_cliente, doc_cliente, 
              inicio_res, fim_res, valor_res); //Fazendo herança completa
        
        this.num_quarto = num_quarto;
        this.num_hospedes = num_hospedes;
        this.serv_quarto = serv_quarto;
    }
    
    
    //Getters and Setters da classe filha

        public int getNum_quarto() {
            return num_quarto;
        }

        public void setNum_quarto(int num_quarto) {
            this.num_quarto = num_quarto;
        }

        public int getNum_hospedes() {
            return num_hospedes;
        }

        public void setNum_hospedes(int num_hospedes) {
            this.num_hospedes = num_hospedes;
        }

        public boolean isServ_quarto() {
            return serv_quarto;
        }

        public void setServ_quarto(boolean serv_quarto) {
            this.serv_quarto = serv_quarto;
        }
    
//==============================================================================
    
    @Override
    public String toString(){
        return "Reserva Hotelaria:{"
                + "\nID = " + getId()
                + "\nid_cliente = " + getId_cliente()
                + "\nNome_cliente = " + getNome_cliente()
                + "\nDocumento_cliente = " + getDoc_cliente()
                + "\nNúmero do Quarto = " + getNum_quarto()
                + "\nNúmero de Hóspedes = " + getNum_hospedes()
                + "\nServiço de Quarto = " + isServ_quarto()
                + "\nPrazo de Início = " + getInicio_res()
                + "\nPrazo de Término = " + getFim_res()
                + "\nValor = " + getValor_res()
                + "}" ;
                
    }
    
    //Como os atributos são privados, necessita que seja usado o método get.

}