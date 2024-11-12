package com.uade.impl;

import com.uade.api.ArbolBinarioTDA;

public class ArbolBinarioTDAImplD implements ArbolBinarioTDA {
    static class NodoABB{
        int dato;
        ArbolBinarioTDA hijoIzq;
        ArbolBinarioTDA hijoDer;
    }
    NodoABB raiz;

    public int raiz() {
        return raiz.dato;
    }

    public ArbolBinarioTDA hijoIzq() {
        return raiz.hijoIzq;
    }

    public ArbolBinarioTDA hijoDer() {
        return raiz.hijoDer;
    }

    public boolean arbolVacio() {
        return (raiz == null);
    }

    public void inicializarArbol() {
        raiz = null;
    }

    public void agregarElemento(int x) {
        if (raiz == null) {
            raiz = new NodoABB();
            raiz.dato = x;
            raiz.hijoIzq = new ArbolBinarioTDAImplD();
            raiz.hijoIzq.inicializarArbol();
            raiz.hijoDer = new ArbolBinarioTDAImplD();
            raiz.hijoDer.inicializarArbol();
        } else if (raiz.dato > x) {
            raiz.hijoIzq.agregarElemento(x);
        } else if (raiz.dato < x) {
            raiz.hijoDer.agregarElemento(x);
        }
    }

    public void eliminarElemento(int x) {
        if (raiz != null) {
            if (raiz.dato == x && raiz.hijoIzq.arbolVacio() && raiz.hijoDer.arbolVacio()) {
                raiz = null;
            } else if (raiz.dato == x && !raiz.hijoIzq.arbolVacio()) {
                raiz.dato = this.mayor(raiz.hijoIzq);
                raiz.hijoIzq.eliminarElemento(raiz.dato);
            } else if (raiz.dato == x && raiz.hijoIzq.arbolVacio()) {
                raiz.dato = this.menor(raiz.hijoDer);
                raiz.hijoDer.eliminarElemento(raiz.dato);
            } else if (raiz.dato < x) {
                raiz.hijoDer.eliminarElemento(x);
            } else {
                raiz.hijoIzq.eliminarElemento(x);
            }
        }
    }

    private int mayor(ArbolBinarioTDA arbol) {
        if (arbol.hijoDer().arbolVacio()) {
            return arbol.raiz();
        } else {
            return mayor(arbol.hijoDer());
        }
    }
    private int menor(ArbolBinarioTDA arbol) {
        if (arbol.hijoIzq().arbolVacio()) {
            return arbol.raiz();
        } else {
            return menor(arbol.hijoIzq());
        }
    }
}