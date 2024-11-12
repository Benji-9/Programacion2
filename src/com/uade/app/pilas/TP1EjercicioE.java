package com.uade.app.pilas;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class TP1EjercicioE {
    public static void main(String[] args) {
        TP1EjercicioE app = new TP1EjercicioE();
        app.execute();
    }

    private void execute() {
        PilaTDA pila = new PilaTDAImpl();

        pila.inicializarPila();

        pila.apilar(10);
        pila.apilar(11);
        pila.apilar(12);

        // Sumar los elementos de la pila
        int suma = OperacionPila.sumarElementos(pila);
        System.out.println("Suma de los elementos en la pila: " + suma);
    }
}