package com.myproject.sistemareservapoo;

import com.myproject.view.ReservasInterface;

/*
    MAIN: Será a página principal. O MAIN.
    No entanto, a única coisa a qual essa página fará é dar start na minha view
de forma que a interface lá contida rode, e as operações possam dar início.
*/

public class SistemaReservaPOO {

    public static void main(String[] args) {
        
        ReservasInterface view  = new ReservasInterface();
        view.iniciarSistema();
    }
}
