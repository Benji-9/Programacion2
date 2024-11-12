package com.uade.app.pilas;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class TP1EjercicioF {
    public static void main(String[] args) {
        TP1EjercicioF app = new TP1EjercicioF();
        app.execute();
    }

    private void execute() {
        PilaTDA pila = new PilaTDAImpl();

        pila.inicializarPila();

        pila.apilar(10);
        pila.apilar(11);
        pila.apilar(12);

        // Calcular el promedio de los elementos de la pila
        double promedio = OperacionPila.promedioElementos(pila);
        System.out.println("Promedio de los elementos en la pila: " + promedio);
    }
}