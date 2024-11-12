package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioN {
    public static void main(String[] args) {
        TP4EjercicioN app = new TP4EjercicioN();
        app.execute();
    }

    private void execute() {
        ArbolBinarioTDA abb = new ArbolBinarioTDAImplD();
        abb.inicializarArbol();

        // Insertamos algunos elementos en el ABB
        abb.agregarElemento(15);
        abb.agregarElemento(10);
        abb.agregarElemento(20);
        abb.agregarElemento(8);
        abb.agregarElemento(12);
        abb.agregarElemento(17);
        abb.agregarElemento(25);

        // Dado un elemento, buscamos su anterior inmediato
        int elemento = 20;
        Integer anterior = encontrarAnterior(abb, elemento);
        if (anterior != null) {
            System.out.println("El elemento anterior a " + elemento + " es: " + anterior);
        } else {
            System.out.println("No se encontró un elemento anterior a " + elemento);
        }
    }

    // Metodo para encontrar el elemento anterior inmediato
    private Integer encontrarAnterior(ArbolBinarioTDA abb, int elemento) {
        // Nodo que almacenará el anterior inmediato
        Integer anterior = null;
        while (!abb.arbolVacio()) {
            if (elemento < abb.raiz()) {
                // Si el elemento buscado es menor, nos movemos a la izquierda
                abb = abb.hijoIzq();
            } else if (elemento > abb.raiz()) {
                // Guardamos el nodo actual como anterior y nos movemos a la derecha
                anterior = abb.raiz();
                abb = abb.hijoDer();
            } else {
                // Elemento encontrado, terminamos la búsqueda
                break;
            }
        }

        // Si encontramos el nodo, buscamos el máximo en el subárbol izquierdo
        if (!abb.arbolVacio()) {
            if (!abb.hijoIzq().arbolVacio()) {
                abb = abb.hijoIzq();
                while (!abb.hijoDer().arbolVacio()) {
                    abb = abb.hijoDer();
                }
                anterior = abb.raiz();
            }
        }

        return anterior;
    }
}