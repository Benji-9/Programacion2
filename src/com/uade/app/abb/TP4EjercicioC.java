package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioC {
    public static void main(String[] args) {
        TP4EjercicioC app = new TP4EjercicioC();
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
        abb.agregarElemento(28);
        abb.agregarElemento(45);

        // Calculamos la profundidad de un elemento
        int elemento = 45;
        int profundidad = calcularProfundidad(abb, elemento);
        System.out.println("La profundidad del elemento " + elemento + " es: " + profundidad);
    }

    // Método recursivo para calcular la profundidad de un elemento en el ABB
    private int calcularProfundidad(ArbolBinarioTDA abb, int elemento) {
        if (abb.arbolVacio()) {
            return -1; // Si el elemento no está en el árbol
        } else if (abb.raiz() == elemento) {
            return 0;
        } else if (elemento < abb.raiz()) {
            int profundidadIzq = calcularProfundidad(abb.hijoIzq(), elemento);
            return (profundidadIzq == -1) ? -1 : 1 + profundidadIzq;
        } else {
            int profundidadDer = calcularProfundidad(abb.hijoDer(), elemento);
            return (profundidadDer == -1) ? -1 : 1 + profundidadDer;
        }
    }
}