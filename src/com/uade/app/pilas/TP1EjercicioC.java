package com.uade.app.pilas;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class TP1EjercicioC {
    public static void main(String[] args) {
        TP1EjercicioC app = new TP1EjercicioC();
        app.execute();
    }

    private void execute() {
        PilaTDA p1 = new PilaTDAImpl();

        p1.inicializarPila();

        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);

        // Invertir el contenido de la pila p1
        OperacionPila.invertirPila(p1);
        System.out.println("Pila p1 invertida:");
        OperacionPila.mostrar(p1);
    }
}
