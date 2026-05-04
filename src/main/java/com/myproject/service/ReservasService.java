package com.myproject.service;

import com.myproject.dao.ReservasDAO;
import com.myproject.model.ReservasModel;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/*
    SERVICE: Aqui é onde estarão as regras de negócio e possíveis cálculos
necessários durante o decorrer do projeto. Também constará as validações 
necessárias para o Controller e a View manterem-se mais limpas e agrupar todas
as decisões de negócio em apenas um local.

*/

public class ReservasService{

    private final ReservasDAO dao = new ReservasDAO();

//==============================================================================
    // CRIAR RESERVA

    public void criarReserva(
            int id_cliente,
            int id_recurso,
            LocalDateTime inicio,
            LocalDateTime fim,
            float valor_base,
            String status
    ) {

        // Validações
        if(inicio.isAfter(fim)) {
            System.out.println("Data inicial maior que data final!");
            return;
        }

        // Calculando diferença de tempo
        long horas = ChronoUnit.HOURS.between(inicio, fim);

        if(horas <= 0) {
            horas = 1;
        }

        //Definindo valor total atravpes das horas e dias
        float total = horas * valor_base;

        ReservasModel reserva = new ReservasModel();

        reserva.setId_cliente(id_cliente);
        reserva.setId_recurso(id_recurso);
        reserva.setInicio_reserva(inicio);
        reserva.setFim_reserva(fim);
        reserva.setTotal_reserva(total);
        reserva.setStatus_reserva(status);

        dao.inserir(reserva);
    }

//==============================================================================
    // LISTAR RESERVAS

    public List<ReservasModel> listarReservas() {
        return dao.listar();
    }

//==============================================================================
    // ATUALIZAR RESERVA

    public void atualizarReserva(
            int id_reserva,
            int id_cliente,
            int id_recurso,
            LocalDateTime inicio,
            LocalDateTime fim,
            float total,
            String status
    ) {

        ReservasModel reserva = new ReservasModel();

        reserva.setId_reserva(id_reserva);
        reserva.setId_cliente(id_cliente);
        reserva.setId_recurso(id_recurso);

        reserva.setInicio_reserva(inicio);
        reserva.setFim_reserva(fim);

        reserva.setTotal_reserva(total);
        reserva.setStatus_reserva(status);

        dao.atualizar(reserva);
    }

//==============================================================================
    // CANCELAR RESERVA

    public void cancelarReserva(int id_reserva) {
        dao.deletar(id_reserva);
    }
}