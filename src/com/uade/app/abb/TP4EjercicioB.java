package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioB {

    public static void main(String[] args) {
        TP4EjercicioB app = new TP4EjercicioB();
        app.execute();
    }

    private void execute() {
        ArbolBinarioTDA arbol = new ArbolBinarioTDAImplD();
        arbol.inicializarArbol();

        arbol.agregarElemento(5);
        arbol.agregarElemento(3);
        arbol.agregarElemento(7);
        arbol.agregarElemento(2);
        arbol.agregarElemento(4);

        int elemento = 7;

        // Verificar si el elemento es una hoja
        boolean esHoja = esHojaRec(arbol, elemento);
        System.out.println("¿El elemento " + elemento + " es una hoja? " + esHoja);
    }

    private static boolean esHojaRec(ArbolBinarioTDA arbol, int x) {
        if (arbol.arbolVacio()) {
            return false; // Árbol vacío, no puede ser una hoja
        } else if (arbol.raiz() == x) {
            return arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio(); // Verificar si ambos hijos son vacíos
        } else if (x < arbol.raiz()) {
            return esHojaRec(arbol.hijoIzq(), x); // Buscar en el subárbol izquierdo
        } else {
            return esHojaRec(arbol.hijoDer(), x); // Buscar en el subárbol derecho
        }
    }
}

