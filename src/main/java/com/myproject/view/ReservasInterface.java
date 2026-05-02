package com.myproject.view;

import com.myproject.controller.ReservasController;
import com.myproject.model.ReservasModel;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/*
    VIEW: Aqui é onde conterá a interface do projeto. A parte na qual o usuário
vai interagir com o sistema, e também obterá as respostas. Elas ocorrerão através
do console (não haverá interface gráfica) e será responsável pelo que o usuário 
pode ou não fazer dentro da aplicação.
*/

public class ReservasInterface {
    
    private final ReservasController controller = new ReservasController();
    
    public void Iniciar(){
        
        System.out.println("==== Teste MVC =====");
        
        controller.criarReserva("Teste MVC");
        
        List<ReservasModel> lista = controller.listarReservas();
        
        for(ReservasModel r : lista) {
            System.out.println(r.getId() + " - " + r.getNome());
        }
        
    }
    
}
