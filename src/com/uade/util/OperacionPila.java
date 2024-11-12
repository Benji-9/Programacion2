package com.uade.util;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;

import java.util.Scanner;

public class OperacionPila {

    public static void mostrar(PilaTDA pila) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!pila.pilaVacia()) {
            System.out.println(pila.tope());
            aux.apilar(pila.tope());
            pila.desapilar();
        }

        // Restaurar la pila original
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }
    }

    public static boolean esCapicua(PilaTDA pila) {
        // Pila auxiliar para clonar la pila original sin modificarla
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();
        PilaTDA invertida = new PilaTDAImpl();
        invertida.inicializarPila();

        // Clonamos la pila original en "aux" y "invertida"
        PilaTDA clon = new PilaTDAImpl();
        clon.inicializarPila();

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            clon.apilar(elemento);    // Clonamos la pila original
            aux.apilar(elemento);     // Llenamos aux para restaurarla después
            invertida.apilar(elemento); // Llenamos la pila invertida
            pila.desapilar();
        }

        // Restauramos la pila original
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        // Comparamos los elementos de la pila original con los de la pila invertida
        boolean esCapicua = true;
        while (!invertida.pilaVacia() && !clon.pilaVacia()) {
            int elementoOriginal = clon.tope();
            int elementoInvertido = invertida.tope();

            if (elementoOriginal != elementoInvertido) {
                esCapicua = false;
                break;
            }

            clon.desapilar();
            invertida.desapilar();
        }

        return esCapicua;
    }

    public void llenar(PilaTDA pila, Scanner scanner, String nombre) {
        System.out.println("Ingrese la cantidad de elementos para la pila " + nombre + ":");
        int n = scanner.nextInt();

        System.out.println("Ingrese los elementos de la pila " + nombre + ":");
        for (int i = 0; i < n; i++) {
            int elemento = scanner.nextInt();
            pila.apilar(elemento);
        }
    }

    public static boolean contieneElemento(PilaTDA mod, int elementoDada) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        boolean encontrado = false;

        while (!mod.pilaVacia()) {
            int elementoMod = mod.tope();
            mod.desapilar();

            if (elementoMod == elementoDada) {
                encontrado = true;
            }

            aux.apilar(elementoMod);
        }

        while (!aux.pilaVacia()) {
            mod.apilar(aux.tope());
            aux.desapilar();
        }

        return encontrado;
    }

    public static void pasarPila(PilaTDA origen, PilaTDA destino) {
        while (!origen.pilaVacia()) {
            destino.apilar(origen.tope());
            origen.desapilar();
        }
    }

    public static void copiarPila(PilaTDA origen, PilaTDA destino) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        // Mover todos los elementos a la pila auxiliar
        while (!origen.pilaVacia()) {
            aux.apilar(origen.tope());
            origen.desapilar();
        }

        // Mover los elementos de la pila auxiliar a las dos pilas (origen y destino)
        while (!aux.pilaVacia()) {
            int tope = aux.tope();
            aux.desapilar();
            origen.apilar(tope);  // restaurar el origen
            destino.apilar(tope); // copiar en destino
        }
    }

    public static void invertirPila(PilaTDA pila) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!pila.pilaVacia()) {
            aux.apilar(pila.tope());
            pila.desapilar();
        }

        // Transferir los elementos de la pila auxiliar de vuelta a la original
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }
    }

    public static int contarElementos(PilaTDA pila) {
        int contador = 0;

        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!pila.pilaVacia()) {
            aux.apilar(pila.tope());
            pila.desapilar();
            contador++;
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        return contador;
    }

    public static int sumarElementos(PilaTDA pila) {
        int suma = 0;
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!pila.pilaVacia()) {
            suma += pila.tope();
            aux.apilar(pila.tope());
            pila.desapilar();
        }

        // Restaurar la pila original
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        return suma;
    }

    public static double promedioElementos(PilaTDA pila) {
        int suma = sumarElementos(pila);
        int cantidad = contarElementos(pila);

        if (cantidad == 0) {
            return 0; // evitar división por cero
        }

        return (double) suma / cantidad;
    }

}
