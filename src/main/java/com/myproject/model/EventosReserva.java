package com.myproject.model;
import java.time.LocalDateTime;

/*
    Classe responsável por registrar os eventos realizados
    dentro de uma reserva, como:
    
    - criação
    - check-in
    - check-out
    - cancelamento
    
    Essa classe será utilizada pelo EventosDAO
    para salvar e listar eventos no banco.
*/

public class EventosReserva {

    private int id_evento;
    private int id_reserva;
    private String tipo_evento;
    private String descricao;
    private LocalDateTime data_evento;

//==============================================================================
    // CONSTRUTOR VAZIO

    public EventosReserva() {
    }

//==============================================================================
    // CONSTRUTOR COMPLETO

    public EventosReserva(
            int id_evento,
            int id_reserva,
            String tipo_evento,
            String descricao,
            LocalDateTime data_evento) {

        this.id_evento = id_evento;
        this.id_reserva = id_reserva;
        this.tipo_evento = tipo_evento;
        this.descricao = descricao;
        this.data_evento = data_evento;
    }

//==============================================================================
    // GETTERS E SETTERS

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDateTime data_evento) {
        this.data_evento = data_evento;
    }

}