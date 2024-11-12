package com.uade.impl;

import com.uade.api.ColaTDA;

public class ColaTDAImplD implements ColaTDA {

    public class Nodo {
        int info;
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    public void inicializarCola() {
        primero = null;
        ultimo = null;
    }

    public void acolar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = null;
        if (ultimo != null) {
            ultimo.sig = aux;
        }
        ultimo = aux;
        if (primero == null) {
            primero = ultimo;
        }
    }

    public void desacolar() {
        primero = primero.sig;
        if (primero == null) {
            ultimo = null;
        }
    }

    public int primero() {
        return primero.info;
    }

    public boolean colaVacia() {
        return (ultimo == null);
    }
}
