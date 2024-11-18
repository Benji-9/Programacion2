package com.uade.app.colas;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.util.OperacionCola;

public class TP3EjercicioC {
    public static void main(String[] args) {
        TP3EjercicioC app = new TP3EjercicioC();
        app.execute();
    }

    private void execute() {
        ColaTDA c1 = new ColaTDAImpl();
        ColaTDA repetidos = new ColaTDAImpl();

        c1.inicializarCola();
        repetidos.inicializarCola();

        c1.acolar(1);
        c1.acolar(2);
        c1.acolar(3);
        c1.acolar(2);
        c1.acolar(4);
        c1.acolar(3);
        c1.acolar(1);

        System.out.println("Cola original:");
        OperacionCola.mostrar(c1);

        obtenerRepetidos(c1, repetidos);

        System.out.println("Elementos repetidos:");
        OperacionCola.mostrar(repetidos);
    }

    private static void obtenerRepetidos(ColaTDA cola, ColaTDA repetidos) {
        ColaTDA aux = new ColaTDAImpl();
        ColaTDA temporal = new ColaTDAImpl();
        aux.inicializarCola();
        temporal.inicializarCola();

        while (!cola.colaVacia()) {
            int actual = cola.primero();
            cola.desacolar();

            boolean encontrado = false;
            boolean repetido = false;

            while (!aux.colaVacia()) {
                int elementoAux = aux.primero();
                aux.desacolar();
                temporal.acolar(elementoAux);

                if (elementoAux == actual) {
                    encontrado = true;
                }
            }

            while (!temporal.colaVacia()) {
                aux.acolar(temporal.primero());
                temporal.desacolar();
            }

            if (encontrado) {
                while (!repetidos.colaVacia()) {
                    int elementoRep = repetidos.primero();
                    repetidos.desacolar();
                    temporal.acolar(elementoRep);

                    if (elementoRep == actual) {
                        repetido = true;
                    }
                }

                while (!temporal.colaVacia()) {
                    repetidos.acolar(temporal.primero());
                    temporal.desacolar();
                }

                if (!repetido) {
                    repetidos.acolar(actual);
                }
            } else {
                aux.acolar(actual);
            }
        }

        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }
    }
}