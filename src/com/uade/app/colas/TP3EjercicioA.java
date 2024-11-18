package com.uade.app.colas;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.util.OperacionCola;

public class TP3EjercicioA {
    public static void main(String[] args) {
        TP3EjercicioA app = new TP3EjercicioA();
        app.execute();
    }

    private void execute() {
        ColaTDA c1 = new ColaTDAImpl();
        c1.inicializarCola();

        c1.acolar(1);
        c1.acolar(2);
        c1.acolar(3);
        c1.acolar(2);
        c1.acolar(4);
        c1.acolar(3);
        c1.acolar(1);

        System.out.println("Cola original:");
        OperacionCola.mostrar(c1);

        eliminarRepetidos(c1);

        System.out.println("Cola sin repeticiones:");
        OperacionCola.mostrar(c1);
    }

    private static void eliminarRepetidos(ColaTDA cola) {
        ColaTDA aux = new ColaTDAImpl();
        ColaTDA temporal = new ColaTDAImpl();
        aux.inicializarCola();
        temporal.inicializarCola();

        while (!cola.colaVacia()) {
            int actual = cola.primero();
            cola.desacolar();

            boolean repetido = false;

            while (!aux.colaVacia()) {
                int elementoAux = aux.primero();
                aux.desacolar();
                temporal.acolar(elementoAux);

                if (elementoAux == actual) {
                    repetido = true;
                }
            }

            while (!temporal.colaVacia()) {
                aux.acolar(temporal.primero());
                temporal.desacolar();
            }

            if (!repetido) {
                aux.acolar(actual);
            }
        }

        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }
    }
}