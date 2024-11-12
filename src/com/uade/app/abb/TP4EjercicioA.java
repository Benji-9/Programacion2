package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioA {

    public static void main(String[] args) {
        TP4EjercicioA app = new TP4EjercicioA();
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

        int elemento = 4;

        // Verificar si el elemento está en el ABB
        boolean existe = contieneElementoRec(arbol, elemento);
        System.out.println("¿El elemento " + elemento + " está en el ABB? " + existe);
    }

    private static boolean contieneElementoRec(ArbolBinarioTDA arbol, int x) {
        if (arbol.arbolVacio()) {
            return false; // El árbol está vacío, no contiene el elemento
        } else if (arbol.raiz() == x) {
            return true; // El elemento es igual a la raíz
        } else if (x < arbol.raiz()) {
            return contieneElementoRec(arbol.hijoIzq(), x); // Buscar en el subárbol izquierdo
        } else {
            return contieneElementoRec(arbol.hijoDer(), x); // Buscar en el subárbol derecho
        }
    }
}
