package com.myproject.controller;

import com.myproject.model.ReservasModel;
import com.myproject.service.ReservasService;
import java.sql.SQLException;
import java.util.List;

/*
    CONTROLLER: Responsável por gerir e administrar o fluxo de comandos entre 
a View e o Service, servindo como uma camada intermediária a qual recebe os
dados da View, chama o Service, e depois retorna os dados para a View.
*/

public class ReservasController {
    
    private ReservasService service = new ReservasService();
    
    public void criarReserva(String nome) {
        service.salvarReserva(nome);
    }
    
    public List<ReservasModel> listarReservas(){
        return service.listarReservas();
    }
    
}
