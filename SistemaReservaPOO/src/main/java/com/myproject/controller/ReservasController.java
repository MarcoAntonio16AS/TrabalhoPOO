package com.myproject.controller;

import com.myproject.model.ReservasModel;
import com.myproject.service.ReservasService;
import java.time.LocalDateTime;
import java.util.List;

/*
    CONTROLLER: Responsável por gerir e administrar o fluxo de comandos entre 
a View e o Service, servindo como uma camada intermediária a qual recebe os
dados da View, chama o Service, e depois retorna os dados para a View.

*/

public class ReservasController {

    private final ReservasService service =
            new ReservasService();

//==============================================================================
    // CRIAR RESERVA

    private final ReservasService ReservasService =
            new ReservasService();

    public boolean criarReserva(
            int idCliente,
            int idRecurso,
            LocalDateTime inicio,
            LocalDateTime fim,
            double valor,
            String status
    ) {

        return ReservasService.criarReserva(
                idCliente,
                idRecurso,
                inicio,
                fim,
                valor,
                status

        );

    }

//==============================================================================
    // LISTAR RESERVAS

    public List<ReservasModel> listarReservas() {
        return service.listarReservas();
    }

//==============================================================================
    // ATUALIZAR RESERVA

    public void atualizarReserva(
            int id_reserva,
            int id_cliente,
            int id_recurso,
            LocalDateTime inicio,
            LocalDateTime fim,
            double total,
            String status
    ) {

        service.atualizarReserva(
                id_reserva,
                id_cliente,
                id_recurso,
                inicio,
                fim,
                total,
                status
        );

    }

//==============================================================================
    // DELETAR RESERVA

    public void deletarReserva(int id_reserva) {
        service.cancelarReserva(id_reserva);
    }

}
