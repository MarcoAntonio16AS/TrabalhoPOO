package com.myproject.service;

import com.myproject.dao.ReservasDAO;
import com.myproject.model.ReservasModel;
import java.sql.SQLException;
import java.util.List;

/*
    SERVICE: Aqui é onde estarão as regras de negócio e possíveis cálculos
necessários durante o decorrer do projeto. Também constará as validações 
necessárias para o Controller e a View manterem-se mais limpas e agrupar todas
as decisões de negócio em apenas um local.
 */
public class ReservasService {

    private final ReservasDAO dao = new ReservasDAO();

    public void salvarReserva(String nome) {

        if (nome == null || nome.isBlank()) {
            System.out.println("Nome inválido!");
            return;
        }

        ReservasModel Reserva = new ReservasModel(nome);
        dao.inserir(Reserva);

    }

    public List<ReservasModel> listarReservas() {
        return dao.Listar();
    }

}
