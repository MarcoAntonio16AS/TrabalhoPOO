package br.edu.agendacrudmysql;

import br.edu.agendacrudmysql.view.ConsoleView;

/**
 * Classe principal: ponto de entrada do programa. Responsável apenas por
 * iniciar a View (console).
 */
public class AgendaCRUDMySQL {

    public static void main(String[] args) {
        new ConsoleView().iniciar();
    }
}
