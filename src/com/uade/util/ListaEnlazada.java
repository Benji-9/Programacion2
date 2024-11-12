package com.uade.util;

public class ListaEnlazada {
    public Nodo head;

    public ListaEnlazada() {
        this.head = null;
    }

    // Agrega un elemento a la lista enlazada si no está ya presente
    public void agregar(int x) {
        if (!pertenece(x)) {
            Nodo nuevo = new Nodo(x);
            nuevo.siguiente = head;
            head = nuevo;
        }
    }

    // Elimina un elemento de la lista enlazada
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
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    // Verifica si un elemento pertenece a la lista enlazada
    public boolean pertenece(int x) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.valor == x) return true;
            actual = actual.siguiente;
        }
        return false;
    }
}