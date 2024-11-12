package com.uade.app.pilas;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class TP3EjercicioB {
    public static void main(String[] args) {
        TP3EjercicioB app = new TP3EjercicioB();
        app.execute();
    }

    private void execute() {
        PilaTDA p1 = new PilaTDAImpl();

        p1.inicializarPila();

        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);
        p1.apilar(3);
        p1.apilar(3);
        p1.apilar(2);

        eliminarRepetidos(p1);

        OperacionPila.mostrar(p1);

    }

    private static void eliminarRepetidos(PilaTDA pila){
        PilaTDA aux = new PilaTDAImpl();
        PilaTDA temporal = new PilaTDAImpl();
        aux.inicializarPila();
        temporal.inicializarPila();

        while (!pila.pilaVacia()) {
            int actual = pila.tope();
            pila.desapilar();

            boolean repetido = false;
            // Revisamos si ya se ha almacenado el elemento en la pila auxiliar
            while (!aux.pilaVacia()) {
                int elementoAux = aux.tope();
                aux.desapilar();
                temporal.apilar(elementoAux); // Guardamos temporalmente

                if (elementoAux == actual) {
                    repetido = true;
                }
            }

            // Restauramos la pila auxiliar
            while (!temporal.pilaVacia()) {
                aux.apilar(temporal.tope());
                temporal.desapilar();
            }

            // Si no es repetido, lo guardamos en la pila auxiliar
            if (!repetido) {
                aux.apilar(actual);
            }
        }

        // Restauramos la pila original
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }
    }
}
