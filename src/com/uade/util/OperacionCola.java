package com.uade.util;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;


import java.util.Scanner;

public class OperacionCola {

    public static void mostrar(ColaTDA cola) {
        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();

        // Guardamos los elementos en una cola auxiliar mientras mostramos
        while (!cola.colaVacia()) {
            int valor = cola.primero();
            System.out.println(valor);
            aux.acolar(valor);
            cola.desacolar();
        }

        // Restauramos la cola original
        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }
    }

    public void llenar(ColaTDA cola, Scanner scanner, String nombre) {
        System.out.println("Ingrese la cantidad de elementos para la cola " + nombre + ":");
        int n = scanner.nextInt();

        System.out.println("Ingrese los elementos de la cola " + nombre + ":");
        for (int i = 0; i < n; i++) {
            int elemento = scanner.nextInt();
            cola.acolar(elemento);
        }
    }

    public static int contarElementos(ColaTDA cola) {
        int contador = 0;
        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();

        pasarCola(cola, aux); // Pasamos los elementos a una cola auxiliar

        while (!aux.colaVacia()) {
            contador++;
            aux.desacolar();
        }

        return contador;
    }

    public static void pasarCola(ColaTDA origen, ColaTDA destino) {
        while (!origen.colaVacia()) {
            destino.acolar(origen.primero());
            origen.desacolar();
        }
    }

    public static void copiarEInvertir(ColaTDA origen, ColaTDA invertida) {
        if (!origen.colaVacia()) {
            int elemento = origen.primero();
            origen.desacolar();
            copiarEInvertir(origen, invertida); // Llamada recursiva para procesar el resto
            invertida.acolar(elemento);         // Insertamos al final para invertir el orden
            origen.acolar(elemento);            // Restauramos la cola original
        }
    }

    public static void copiarEInvertirCapicua(ColaTDA cola, ColaTDA aux, ColaTDA invertida) {
        if (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            aux.acolar(elemento);
            copiarEInvertirCapicua(cola, aux, invertida);
            invertida.acolar(elemento);
            cola.acolar(elemento);
        }
    }
}
