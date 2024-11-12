package com.uade.impl.conjunto;

import com.uade.api.ConjuntoTDA;
import com.uade.util.ListaEnlazada;

public class ConjuntoUniversoAcotado implements ConjuntoTDA {
    public static final int N = 1000; // Máximo valor en el universo
    public ListaEnlazada[] tabla;

    // Constructor que inicializa la tabla hash
    public ConjuntoUniversoAcotado() {
        this.tabla = new ListaEnlazada[N + 1]; // +1 porque el índice va de 0 a N
        for (int i = 0; i <= N; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }

    // Inicializa el conjunto como vacío
    public void inicializarConjunto() {
        for (int i = 0; i <= N; i++) {
            tabla[i].head = null;
        }
    }

    // Agrega un elemento al conjunto si está en el rango válido
    public void agregar(int x) {
        if (x >= 0 && x <= N) {
            tabla[x].agregar(x);
        }
    }

    // Elige un elemento del conjunto (en este caso, el primero no nulo)
    public int elegir() {
        for (int i = 0; i <= N; i++) {
            if (tabla[i].head != null) return tabla[i].head.valor;
        }
        throw new RuntimeException("Conjunto vacío");
    }

    // Elimina un elemento del conjunto si está en el rango válido
    public void sacar(int x) {
        if (x >= 0 && x <= N) {
            tabla[x].sacar(x);
        }
    }

    // Verifica si un elemento pertenece al conjunto
    public boolean pertenece(int x) {
        return x >= 0 && x <= N && tabla[x].pertenece(x);
    }

    // Verifica si el conjunto está vacío
    public boolean conjuntoVacio() {
        for (int i = 0; i <= N; i++) {
            if (tabla[i].head != null) return false;
        }
        return true;
    }
}