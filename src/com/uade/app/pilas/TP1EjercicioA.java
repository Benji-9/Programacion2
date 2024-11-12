package com.uade.app.pilas;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class TP1EjercicioA {

    public static void main(String[] args) {
        TP1EjercicioA app = new TP1EjercicioA();
        app.execute();
    }

    private void execute() {
        PilaTDA p1 = new PilaTDAImpl();
        PilaTDA p2 = new PilaTDAImpl();

        p1.inicializarPila();
        p2.inicializarPila();

        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);

        // Pasar pila p1 a p2 (orden inverso)
        OperacionPila.pasarPila(p1, p2);
        // Mostrar el contenido de la pila p2
        System.out.println("Pila p2 (p1 pasada en orden inverso):");
        OperacionPila.mostrar(p2);
    }

}