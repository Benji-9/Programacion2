package com.uade.app.colas;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionCola;

public class TP1EjercicioB {

    public static void main(String[] args) {
        TP1EjercicioB app = new TP1EjercicioB();
        app.execute();
    }

    public void execute() {
        ColaTDA C1 = new ColaTDAImpl();

        C1.inicializarCola();

        C1.acolar(1);
        C1.acolar(2);
        C1.acolar(3);

        invertirConPila(C1);

        OperacionCola.mostrar(C1);
    }

    private static void invertirConPila(ColaTDA cola) {
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();

        // Pasar todos los elementos de la cola a la pila
        while (!cola.colaVacia()) {
            pila.apilar(cola.primero());
            cola.desacolar();
        }

        // Pasar los elementos de la pila nuevamente a la cola
        while (!pila.pilaVacia()) {
            cola.acolar(pila.tope());
            pila.desapilar();
        }
    }
}
