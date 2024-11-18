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

        abb.agregarElemento(15);
        abb.agregarElemento(10);
        abb.agregarElemento(20);
        abb.agregarElemento(8);
        abb.agregarElemento(12);
        abb.agregarElemento(17);
        abb.agregarElemento(25);

        int elemento = 8;
        int anterior = encontrarAnterior(abb, elemento);
        if (anterior != -1) {
            System.out.println("El elemento anterior a " + elemento + " es: " + anterior);
        } else {
            System.out.println("No se encontró un elemento anterior a " + elemento);
        }
    }

    private int encontrarAnterior(ArbolBinarioTDA abb, int elemento) {
        int anterior = -1;
        while (!abb.arbolVacio()) {
            if (elemento < abb.raiz()) {
                abb = abb.hijoIzq();
            } else if (elemento > abb.raiz()) {
                anterior = abb.raiz();
                abb = abb.hijoDer();
            } else {
                break;
            }
        }

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