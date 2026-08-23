package com.myproject.service;

import com.myproject.dao.EventosDAO;
import com.myproject.model.EventosReserva;

import java.time.LocalDateTime;
import java.util.List;


public class EventosService {

    private EventosDAO dao = new EventosDAO();

    public void registrarEvento(
            int idReserva,
            String tipoEvento,
            String descricao
    ) {

        EventosReserva evento = new EventosReserva();

        evento.setId_reserva(idReserva);

        evento.setTipo_evento(tipoEvento);

        evento.setDescricao(descricao);

        evento.setData_evento(
                LocalDateTime.now()
        );

        dao.registrarEvento(evento);
    }

    public List<EventosReserva> listarEventos() {

        return dao.listarEventos();
    }
}