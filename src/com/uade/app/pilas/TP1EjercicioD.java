package com.uade.app.pilas;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class TP1EjercicioD {
    public static void main(String[] args) {
        TP1EjercicioD app = new TP1EjercicioD();
        app.execute();
    }

    private void execute() {
        PilaTDA pila = new PilaTDAImpl();

        pila.inicializarPila();

        pila.apilar(10);
        pila.apilar(11);
        pila.apilar(12);

        // Contar los elementos de la pila
        int cantidad = OperacionPila.contarElementos(pila);
        System.out.println("Cantidad de elementos en pila: " + cantidad);
    }
}
