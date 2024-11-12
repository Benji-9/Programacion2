package com.uade.impl;

import com.uade.api.PilaTDA;

public class PilaTDAImplD implements PilaTDA {

    public class Nodo {
        int info;
        Nodo sig;
    }

    Nodo primero;

    public void inicializarPila() {
        primero = null;
    }

    public void apilar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = primero;
        primero = aux;
    }

    public void desapilar() {
        primero = primero.sig;
    }

    public int tope() {
        return (primero.info);
    }

    public boolean pilaVacia() {
        return (primero == null);
    }
}
