package com.uade.impl.conjunto;

import com.uade.api.ConjuntoTDA;
import com.uade.util.Nodo;

public class ConjuntoMaximoAcotado implements ConjuntoTDA {
    public static final int max = 100;
    public Nodo prim;
    public int cant;

    // Inicializa el conjunto como vacío
    public void inicializarConjunto() {
        prim = null;
        cant = 0;
    }

    // Agrega un elemento al conjunto si hay espacio y no está ya presente
    public void agregar(int x) {
        if (cant < max && !pertenece(x)) {
            Nodo nuevo = new Nodo(x);
            nuevo.siguiente = prim;
            prim = nuevo;
            cant++;
        }
    }

    public int elegir() {
        if (conjuntoVacio()) throw new RuntimeException("Conjunto vacío");
        return prim.valor;
    }

    public void sacar(int x) {
        Nodo actual = prim;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.valor == x) {
                if (anterior == null) {
                    prim = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                cant--;
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    public boolean pertenece(int x) {
        Nodo actual = prim;
        while (actual != null) {
            if (actual.valor == x) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean conjuntoVacio() {
        return cant == 0;
    }
}