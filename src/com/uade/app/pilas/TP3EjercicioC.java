package com.uade.app.pilas;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class TP3EjercicioC {
    public static void main(String[] args) {
        TP3EjercicioC app = new TP3EjercicioC();
        app.execute();
    }

    private void execute() {
        PilaTDA p1 = new PilaTDAImpl();
        PilaTDA mitad1 = new PilaTDAImpl();
        PilaTDA mitad2 = new PilaTDAImpl();

        p1.inicializarPila();
        mitad1.inicializarPila();
        mitad2.inicializarPila();

        // Apilamos elementos (asumiendo un número par de elementos)
        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);
        p1.apilar(4);
        p1.apilar(5);
        p1.apilar(6);

        // Mostramos la pila original
        System.out.println("Pila original:");
        OperacionPila.mostrar(p1);

        // Repartimos la pila en dos mitades
        repartirMitades(p1, mitad1, mitad2);

        // Mostramos las mitades
        System.out.println("Mitad 1:");
        OperacionPila.mostrar(mitad1);

        System.out.println("Mitad 2:");
        OperacionPila.mostrar(mitad2);
    }

    private static void repartirMitades(PilaTDA pila, PilaTDA mitad1, PilaTDA mitad2) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();
        int total = 0;

        // Contar los elementos
        while (!pila.pilaVacia()) {
            aux.apilar(pila.tope());
            pila.desapilar();
            total++;
        }

        int mitad = total / 2;

        // Restaurar y dividir las mitades
        while (!aux.pilaVacia()) {
            int elemento = aux.tope();
            aux.desapilar();

            if (total > mitad) {
                mitad1.apilar(elemento);
            } else {
                mitad2.apilar(elemento);
            }
            pila.apilar(elemento);
            total--;
        }
    }
}