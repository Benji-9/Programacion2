package com.uade.app.pilas;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class TP3EjercicioD {
    public static void main(String[] args) {
        TP3EjercicioD app = new TP3EjercicioD();
        app.execute();
    }

    private void execute() {
        PilaTDA p1 = new PilaTDAImpl();
        PilaTDA repetidos = new PilaTDAImpl();

        p1.inicializarPila();
        repetidos.inicializarPila();

        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);
        p1.apilar(2);
        p1.apilar(4);
        p1.apilar(3);
        p1.apilar(1);

        System.out.println("Pila original:");
        OperacionPila.mostrar(p1);

        obtenerRepetidos(p1, repetidos);

        System.out.println("Elementos repetidos:");
        OperacionPila.mostrar(repetidos);
    }

    private static void obtenerRepetidos(PilaTDA pila, PilaTDA repetidos) {
        PilaTDA aux = new PilaTDAImpl();
        PilaTDA temporal = new PilaTDAImpl();
        aux.inicializarPila();
        temporal.inicializarPila();

        while (!pila.pilaVacia()) {
            int actual = pila.tope();
            pila.desapilar();

            boolean encontrado = false;
            boolean repetido = false;

            while (!aux.pilaVacia()) {
                int elementoAux = aux.tope();
                aux.desapilar();
                temporal.apilar(elementoAux);

                if (elementoAux == actual) {
                    encontrado = true;
                }
            }

            while (!temporal.pilaVacia()) {
                aux.apilar(temporal.tope());
                temporal.desapilar();
            }

            if (encontrado) {
                while (!repetidos.pilaVacia()) {
                    int elementoRep = repetidos.tope();
                    repetidos.desapilar();
                    temporal.apilar(elementoRep);

                    if (elementoRep == actual) {
                        repetido = true;
                    }
                }

                while (!temporal.pilaVacia()) {
                    repetidos.apilar(temporal.tope());
                    temporal.desapilar();
                }

                if (!repetido) {
                    repetidos.apilar(actual);
                }
            } else {
                aux.apilar(actual);
            }
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }
    }
}