package com.myproject.controller;

import com.myproject.model.EventosReserva;
import com.myproject.service.EventosService;
import java.util.List;

/*
    CONTROLLER: Responsável por gerir e administrar o fluxo de comandos entre 
a View e o Service, servindo como uma camada intermediária a qual recebe os
dados da View, chama o Service, e depois retorna os dados para a View.

*/

public class EventosController {

    private final EventosService service =
            new EventosService();

//==============================================================================
    // REGISTRAR EVENTO

    public void registrarEvento(
            int id_reserva,
            String tipo,
            String descricao
    ) {

        service.registrarEvento(
                id_reserva,
                tipo,
                descricao
        );

    }

//==============================================================================
    // LISTAR EVENTOS

    public List<EventosReserva> listarEventos() {
        return service.listarEventos();
    }

//==============================================================================
    // DELETAR EVENTO

    public void deletarEvento(int id_evento) {
        service.deletarEvento(id_evento);
    }

}