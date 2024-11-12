package com.uade.util;

public class Nodo {
    public int valor; // Valor del nodo
    public Nodo siguiente; // Referencia al siguiente nodo

    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}