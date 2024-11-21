package com.uade.impl.conjunto;

import com.uade.api.ConjuntoTDA;
import com.uade.util.ListaEnlazada;

public class ConjuntoUniversoAcotado implements ConjuntoTDA {
    public static final int N = 1000;
    public ListaEnlazada[] tabla;

    public ConjuntoUniversoAcotado() {
        this.tabla = new ListaEnlazada[N + 1];
        for (int i = 0; i <= N; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }

    public void inicializarConjunto() {
        for (int i = 0; i <= N; i++) {
            tabla[i].head = null;
        }
    }

    public void agregar(int x) {
        if (x >= 0 && x <= N) {
            tabla[x].agregar(x);
        }
    }

    public int elegir() {
        for (int i = 0; i <= N; i++) {
            if (tabla[i].head != null) return tabla[i].head.valor;
        }
        throw new RuntimeException("Conjunto vacío");
    }

    public void sacar(int x) {
        if (x >= 0 && x <= N) {
            tabla[x].sacar(x);
        }
    }

    public boolean pertenece(int x) {
        return x >= 0 && x <= N && tabla[x].pertenece(x);
    }

    public boolean conjuntoVacio() {
        for (int i = 0; i <= N; i++) {
            if (tabla[i].head != null) return false;
        }
        return true;
    }
}