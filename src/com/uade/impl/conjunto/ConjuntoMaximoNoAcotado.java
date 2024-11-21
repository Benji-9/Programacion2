package com.uade.impl.conjunto;

import com.uade.api.ConjuntoTDA;
import com.uade.util.Nodo;

public class ConjuntoMaximoNoAcotado implements ConjuntoTDA {
    public Nodo prim;

    public void inicializarConjunto() {
        prim = null;
    }

    public void agregar(int x) {
        if (!pertenece(x)) {
            Nodo nuevo = new Nodo(x);
            nuevo.siguiente = prim;
            prim = nuevo;
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
        return prim == null;
    }
}