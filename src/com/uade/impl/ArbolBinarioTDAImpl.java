package com.uade.impl;

import com.uade.api.ArbolBinarioTDA;

public class ArbolBinarioTDAImpl implements ArbolBinarioTDA {
    int[] dato;
    int[] hijoIzq;
    int[] hijoDer;
    int raiz;
    int libre; // siguiente nodo libre

    public ArbolBinarioTDAImpl() {
        dato = new int[100];
        hijoIzq = new int[100];
        hijoDer = new int[100];
    }

    public void inicializarArbol() {
        raiz = -1;
        libre = 0;
        for (int i = 0; i < 100; i++) {
            hijoIzq[i] = -1;
            hijoDer[i] = -1;
        }
    }

    public int raiz() {
        return dato[raiz];
    }

    public ArbolBinarioTDA hijoIzq() {
        ArbolBinarioTDAImpl subArbol = new ArbolBinarioTDAImpl();
        subArbol.inicializarArbol();
        subArbol.raiz = hijoIzq[raiz];
        subArbol.dato = dato;
        subArbol.hijoIzq = hijoIzq;
        subArbol.hijoDer = hijoDer;
        return subArbol;
    }

    public ArbolBinarioTDA hijoDer() {
        ArbolBinarioTDAImpl subArbol = new ArbolBinarioTDAImpl();
        subArbol.inicializarArbol();
        subArbol.raiz = hijoDer[raiz];
        subArbol.dato = dato;
        subArbol.hijoIzq = hijoIzq;
        subArbol.hijoDer = hijoDer;
        return subArbol;
    }

    public boolean arbolVacio() {
        return raiz == -1;
    }

    public void agregarElemento(int x) {
        if (raiz == -1) {
            raiz = libre;
            dato[libre] = x;
            libre++;
        } else {
            agregarRecursivo(raiz, x);
        }
    }

    private void agregarRecursivo(int nodo, int x) {
        if (x < dato[nodo]) {
            if (hijoIzq[nodo] == -1) {
                hijoIzq[nodo] = libre;
                dato[libre] = x;
                libre++;
            } else {
                agregarRecursivo(hijoIzq[nodo], x);
            }
        } else if (x > dato[nodo]) {
            if (hijoDer[nodo] == -1) {
                hijoDer[nodo] = libre;
                dato[libre] = x;
                libre++;
            } else {
                agregarRecursivo(hijoDer[nodo], x);
            }
        }
    }

    public void eliminarElemento(int x) {
        eliminarRecursivo(-1, raiz, x);
    }

    private void eliminarRecursivo(int padre, int nodo, int x) {
        if (nodo == -1) return;
        if (dato[nodo] == x) {
            if (hijoIzq[nodo] == -1 && hijoDer[nodo] == -1) {
                actualizarHijo(padre, nodo, -1); // Nodo hoja
            } else if (hijoIzq[nodo] != -1) {
                int mayor = mayor(hijoIzq[nodo]);
                dato[nodo] = mayor;
                eliminarRecursivo(nodo, hijoIzq[nodo], mayor);
            } else {
                int menor = menor(hijoDer[nodo]);
                dato[nodo] = menor;
                eliminarRecursivo(nodo, hijoDer[nodo], menor);
            }
        } else if (x < dato[nodo]) {
            eliminarRecursivo(nodo, hijoIzq[nodo], x);
        } else {
            eliminarRecursivo(nodo, hijoDer[nodo], x);
        }
    }

    private void actualizarHijo(int padre, int nodo, int nuevoValor) {
        if (padre == -1) {
            raiz = nuevoValor;
        } else if (hijoIzq[padre] == nodo) {
            hijoIzq[padre] = nuevoValor;
        } else {
            hijoDer[padre] = nuevoValor;
        }
    }

    private int mayor(int nodo) {
        while (hijoDer[nodo] != -1) {
            nodo = hijoDer[nodo];
        }
        return dato[nodo];
    }

    private int menor(int nodo) {
        while (hijoIzq[nodo] != -1) {
            nodo = hijoIzq[nodo];
        }
        return dato[nodo];
    }
}