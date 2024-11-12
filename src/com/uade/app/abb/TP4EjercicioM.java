package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.api.ConjuntoTDA;

public class TP4EjercicioM {
    public static void main(String[] args) {
        TP4EjercicioM app = new TP4EjercicioM();
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

        // Crear el conjunto de elementos del ABB
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        llenarConjuntoConABB(abb, conjunto);

        System.out.println("Elementos en el conjunto:");
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.print(elemento + " ");
            conjunto.sacar(elemento);
        }
    }

    // Método recursivo para llenar un conjunto con los elementos del ABB
    private void llenarConjuntoConABB(ArbolBinarioTDA abb, ConjuntoTDA conjunto) {
        if (!abb.arbolVacio()) {
            conjunto.agregar(abb.raiz());
            llenarConjuntoConABB(abb.hijoIzq(), conjunto);
            llenarConjuntoConABB(abb.hijoDer(), conjunto);
        }
    }
}