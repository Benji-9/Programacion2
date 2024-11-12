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

        // Acolamos elementos con repeticiones
        c1.acolar(1);
        c1.acolar(2);
        c1.acolar(3);
        c1.acolar(2);
        c1.acolar(4);
        c1.acolar(3);
        c1.acolar(1);

        // Mostramos la cola original
        System.out.println("Cola original:");
        OperacionCola.mostrar(c1);

        // Obtenemos los elementos repetidos
        obtenerRepetidos(c1, repetidos);

        // Mostramos los elementos repetidos
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

            // Revisamos si el elemento ya se encuentra en aux
            while (!aux.colaVacia()) {
                int elementoAux = aux.primero();
                aux.desacolar();
                temporal.acolar(elementoAux);

                if (elementoAux == actual) {
                    encontrado = true;
                }
            }

            // Restauramos la cola auxiliar
            while (!temporal.colaVacia()) {
                aux.acolar(temporal.primero());
                temporal.desacolar();
            }

            // Si ya se encontró antes, verificamos si ya está en la cola de repetidos
            if (encontrado) {
                while (!repetidos.colaVacia()) {
                    int elementoRep = repetidos.primero();
                    repetidos.desacolar();
                    temporal.acolar(elementoRep);

                    if (elementoRep == actual) {
                        repetido = true;
                    }
                }

                // Restauramos la cola de repetidos
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

        // Restauramos la cola original
        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }
    }
}