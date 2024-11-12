package com.uade.impl.conjunto;

import com.uade.api.ConjuntoTDA;
import com.uade.util.Nodo;

public class ConjuntoMaximoAcotado implements ConjuntoTDA {
    public static final int MAX_SIZE = 100; // Tamaño máximo del conjunto
    public Nodo head; // Cabeza de la lista enlazada
    public int cant; // Número de elementos en el conjunto

    // Inicializa el conjunto como vacío
    public void inicializarConjunto() {
        head = null;
        cant = 0;
    }

    // Agrega un elemento al conjunto si hay espacio y no está ya presente
    public void agregar(int x) {
        if (cant < MAX_SIZE && !pertenece(x)) {
            Nodo nuevo = new Nodo(x);
            nuevo.siguiente = head;
            head = nuevo;
            cant++;
        }
    }

    // Elige un elemento del conjunto (en este caso, el primero)
    public int elegir() {
        if (conjuntoVacio()) throw new RuntimeException("Conjunto vacío");
        return head.valor; // Elegimos el primer elemento para simplicidad
    }

    // Elimina un elemento del conjunto
    public void sacar(int x) {
        Nodo actual = head;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.valor == x) {
                if (anterior == null) {
                    head = actual.siguiente;
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

    // Verifica si un elemento pertenece al conjunto
    public boolean pertenece(int x) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.valor == x) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    // Verifica si el conjunto está vacío
    public boolean conjuntoVacio() {
        return cant == 0;
    }
}