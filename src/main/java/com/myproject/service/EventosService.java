package com.myproject.service;

import com.myproject.dao.EventosDAO;
import com.myproject.model.EventosReserva;
import java.time.LocalDateTime;
import java.util.List;

/*
    SERVICE: Aqui é onde estarão as regras de negócio e possíveis cálculos
necessários durante o decorrer do projeto. Também constará as validações 
necessárias para o Controller e a View manterem-se mais limpas e agrupar todas
as decisões de negócio em apenas um local.

*/

public class EventosService {

    private final EventosDAO dao = new EventosDAO();

//===============================================================================
    // REGISTRAR EVENTO

    public void registrarEvento(
            int id_reserva,
            String tipo,
            String descricao
    ) {

        EventosReserva evento = new EventosReserva();

        evento.setId_reserva(id_reserva);
        evento.setTipo_evento(tipo);
        evento.setDescricao(descricao);

        evento.setData_evento(LocalDateTime.now());

        dao.inserir(evento);
    }

//==============================================================================
    // LISTAR EVENTOS

    public List<EventosReserva> listarEventos() {
        return dao.listar();
    }

//==============================================================================
    // DELETAR EVENTO

    public void deletarEvento(int id_evento) {
        dao.deletar(id_evento);
    }
}
