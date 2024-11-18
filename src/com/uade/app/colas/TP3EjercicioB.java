package com.uade.app.colas;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.util.OperacionCola;

public class TP3EjercicioB {
    public static void main(String[] args) {
        TP3EjercicioB app = new TP3EjercicioB();
        app.execute();
    }

    private void execute() {
        ColaTDA c1 = new ColaTDAImpl();
        ColaTDA mitad1 = new ColaTDAImpl();
        ColaTDA mitad2 = new ColaTDAImpl();

        c1.inicializarCola();
        mitad1.inicializarCola();
        mitad2.inicializarCola();

        c1.acolar(1);
        c1.acolar(2);
        c1.acolar(3);
        c1.acolar(4);
        c1.acolar(5);
        c1.acolar(6);

        System.out.println("Cola original:");
        OperacionCola.mostrar(c1);

        repartirMitades(c1, mitad1, mitad2);

        System.out.println("Mitad 1:");
        OperacionCola.mostrar(mitad1);

        System.out.println("Mitad 2:");
        OperacionCola.mostrar(mitad2);
    }

    private static void repartirMitades(ColaTDA cola, ColaTDA mitad1, ColaTDA mitad2) {
        int total = 0;
        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            aux.acolar(cola.primero());
            cola.desacolar();
            total++;
        }

        int mitad = total / 2;

        while (!aux.colaVacia()) {
            int elemento = aux.primero();
            aux.desacolar();

            if (total > mitad) {
                mitad1.acolar(elemento);
            } else {
                mitad2.acolar(elemento);
            }
            cola.acolar(elemento);
            total--;
        }
    }
}