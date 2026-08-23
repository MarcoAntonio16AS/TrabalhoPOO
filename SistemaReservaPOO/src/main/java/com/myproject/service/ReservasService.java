package com.myproject.service;

import com.myproject.dao.ReservasDAO;
import com.myproject.model.ReservasModel;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

/*
    SERVICE: Aqui é onde estarão as regras de negócio e possíveis cálculos
necessários durante o decorrer do projeto. Também constará as validações 
necessárias para o Controller e a View manterem-se mais limpas e agrupar todas
as decisões de negócio em apenas um local.

*/

public class ReservasService{
    Scanner sc = new Scanner(System.in);

    private final EventosService eventosService = new EventosService();
    private final ReservasDAO dao = new ReservasDAO();

//==============================================================================
    //CRIAR RESERVA

    public boolean criarReserva(
        int id_cliente,
        int id_recurso,
        LocalDateTime inicio,
        LocalDateTime fim,
        double valor_base,
        String status
) {

    // VALIDANDO DATAS
    if (inicio.isAfter(fim)) {
        System.out.println("Data inicial maior que data final!");
        return false;
    }

    // VERIFICANDO DISPONIBILIDADE
    boolean disponivel =
            verificarDisponibilidade(
                    id_recurso,
                    inicio,
                    fim
            );

    if (!disponivel) {
        System.out.println("Recurso indisponível nesse horário!");
        return false;
    }

    // CRIANDO RESERVA

    ReservasModel reserva = new ReservasModel();

    reserva.setId_cliente(id_cliente);
    reserva.setId_recurso(id_recurso);

    reserva.setInicio_reserva(inicio);
    reserva.setFim_reserva(fim);


    // CALCULANDO HORAS
        long horasTotais =
                ChronoUnit.HOURS.between(
                        inicio,
                        fim
                );

        long dias = horasTotais / 24;

        long horasRestantes =
                horasTotais % 24;

        double valorDias =
                dias * valor_base;

        double valorHoras =
                horasRestantes * valor_base;

        double total =
                valorDias + valorHoras;
                reserva.setTotal_reserva(total);

    // DEFININDO STATUS
    reserva.setStatus_reserva(status);

    // SALVANDO RESERVA
    dao.inserir(reserva);

        eventosService.registrarEvento(
                reserva.getId_reserva(),
                "CRIAÇÃO",
                "Reserva criada com status ATIVA"
        );

    return true;

}

//==============================================================================
    // LISTAR RESERVAS

    public List<ReservasModel> listarReservas() {
        return dao.listar();
    }

//==============================================================================
public void atualizarReserva(
        int id_reserva,
        int id_cliente,
        int id_recurso,
        LocalDateTime inicio,
        LocalDateTime fim,
        double valor_base,
        String status
) {

    ReservasModel reserva =
            new ReservasModel();

    reserva.setId_reserva(id_reserva);

    reserva.setId_cliente(id_cliente);

    reserva.setId_recurso(id_recurso);

    reserva.setInicio_reserva(inicio);

    reserva.setFim_reserva(fim);

    // DEFININDO STATUS

    reserva.setStatus_reserva(status);

    // CALCULANDO TEMPO

    long horas =
            ChronoUnit.HOURS.between(
                    inicio,
                    fim
            );

    long dias = horas / 24;

    double total = 0;

    if (horas < 24) {
        total = horas * valor_base;
    }

    else if (dias >= 1) {
        total = dias * valor_base;
    }



    // REGRAS DE STATUS
    switch (status) {

        case "ATIVA":
            break;

        case "CANCELADA":

            total *= 0.2;

            break;

        case "FINALIZADA":
            break;
    }

    reserva.setTotal_reserva(total);

    // ATUALIZANDO BANCO

    dao.atualizar(reserva);

    // REGISTRANDO EVENTO

    eventosService.registrarEvento(
            reserva.getId_reserva(),
            "ATUALIZAÇÃO",
            "Reserva atualizada para status "
                    + status
    );

    eventosService.registrarEvento(
            reserva.getId_reserva(),
            "CANCELAMENTO",
            "Reserva cancelada pelo usuário"
    );

    eventosService.registrarEvento(
            reserva.getId_reserva(),
            "FINALIZAÇÃO",
            "Reserva finalizada"
    );

}

//==============================================================================
    // CANCELAR RESERVA

    public void cancelarReserva(int id_reserva) {
        dao.deletar(id_reserva);
    }

//==============================================================================
    // VERIFICAR DISPONIBILIDADE
    private final ReservasDAO ReservasDAO = new ReservasDAO();

    public boolean verificarDisponibilidade(
            int id_recurso,
            LocalDateTime inicio,
            LocalDateTime fim
    ) {

        List<ReservasModel> reservas =
                ReservasDAO.buscarReservasPorRecurso(id_recurso);

        for (ReservasModel reserva : reservas) {

            boolean conflito =
                    inicio.isBefore(reserva.getFim_reserva())
                            &&
                            fim.isAfter(reserva.getInicio_reserva());

            if (conflito) {
                return false;
            }
        }

        return true;
    }

}