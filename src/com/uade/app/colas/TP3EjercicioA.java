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

        // Eliminamos los elementos repetidos
        eliminarRepetidos(c1);

        // Mostramos la cola sin repeticiones
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

            // Revisamos si el elemento ya se encuentra en la cola auxiliar
            while (!aux.colaVacia()) {
                int elementoAux = aux.primero();
                aux.desacolar();
                temporal.acolar(elementoAux);

                if (elementoAux == actual) {
                    repetido = true;
                }
            }

            // Restauramos la cola auxiliar
            while (!temporal.colaVacia()) {
                aux.acolar(temporal.primero());
                temporal.desacolar();
            }

            // Si no es repetido, lo agregamos a la cola auxiliar
            if (!repetido) {
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