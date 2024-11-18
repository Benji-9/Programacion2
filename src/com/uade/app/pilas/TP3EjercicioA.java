package com.uade.app.pilas;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class TP3EjercicioA {
    public static void main(String[] args) {
        TP3EjercicioA app = new TP3EjercicioA();
        app.execute();
    }

    private void execute() {
        PilaTDA p1 = new PilaTDAImpl();

        p1.inicializarPila();

        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);
        p1.apilar(2);
        p1.apilar(1);

        boolean resultado = OperacionPila.esCapicua(p1);

        if (resultado) {
            System.out.println("Es capicua");
        }else {
            System.out.println("No es capicua");
        }
    }
}
