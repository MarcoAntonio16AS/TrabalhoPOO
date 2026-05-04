package com.myproject.model;
import java.time.LocalDateTime;

/*
    MODEL: É o modelo no qual o projeto se baseia e vai se construir. Aqui terá
as nossas classes, objetos, dados encapsulados, método construtor e os getters e
setters, uma vez que os parâmetros serão privados.
*/

public class ReservasModel {
    private int id_reserva, id_cliente, id_recurso;
    private LocalDateTime inicio_reserva, fim_reserva;
    private float total_reserva;
    private String status_reserva;
    

    //Método construtor vazio => Vai ser preenchido com os dados!
    public ReservasModel(){
    }
        
//==============================================================================
    
    //Método construtor completo:

        public ReservasModel(int id_reserva, int id_cliente, int id_recurso, 
                             LocalDateTime inicio_reserva, String status_reserva, 
                             LocalDateTime fim_reserva, float total_reserva) {
            
            this.id_reserva = id_reserva;
            this.id_cliente = id_cliente;
            this.id_recurso = id_recurso;
            this.inicio_reserva = inicio_reserva;
            this.fim_reserva = fim_reserva;
            this.status_reserva = status_reserva;
            this.total_reserva = total_reserva;
        }

    
//==============================================================================    
    
        //Getters and Setters:

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public LocalDateTime getInicio_reserva() {
        return inicio_reserva;
    }

    public void setInicio_reserva(LocalDateTime inicio_reserva) {
        this.inicio_reserva = inicio_reserva;
    }

    public LocalDateTime getFim_reserva() {
        return fim_reserva;
    }

    public void setFim_reserva(LocalDateTime fim_reserva) {
        this.fim_reserva = fim_reserva;
    }

    public float getTotal_reserva() {
        return total_reserva;
    }

    public void setTotal_reserva(float total_reserva) {
        this.total_reserva = total_reserva;
    }

    public String getStatus_reserva() {
        return status_reserva;
    }

    public void setStatus_reserva(String status_reserva) {
        this.status_reserva = status_reserva;
    }

}
