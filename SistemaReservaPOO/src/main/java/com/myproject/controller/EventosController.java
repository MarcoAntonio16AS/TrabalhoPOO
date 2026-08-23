package com.myproject.controller;

import com.myproject.model.EventosReserva;
import com.myproject.service.EventosService;

import java.util.List;

public class EventosController {

    private final EventosService service = new EventosService();

    public List<EventosReserva> registrarEvento(
            int idReserva,
            String tipoEvento,
            String descricao
    ) {

        service.registrarEvento(
                idReserva,
                tipoEvento,
                descricao
        );

        return null;
    }

    public List<EventosReserva> listarEventos() {

        return service.listarEventos();
    }

}