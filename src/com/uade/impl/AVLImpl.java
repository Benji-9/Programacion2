package com.uade.impl;

import com.uade.api.ArbolBinarioTDA;

public class AVLImpl implements ArbolBinarioTDA {

    class NodoAVL {
        int raiz;
        AVLImpl hijoIzq;
        AVLImpl hijoDer;
    }

    NodoAVL nodo;

    @Override
    public void agregarElemento(int x) {
        if (nodo == null) {
            nodo = new NodoAVL();
            nodo.raiz = x;
            nodo.hijoIzq = new AVLImpl();
            nodo.hijoIzq.inicializarArbol();
            nodo.hijoDer = new AVLImpl();
            nodo.hijoDer.inicializarArbol();
            System.out.println("Agrego:" + x);
        } else {
            if (nodo.raiz > x) {
                nodo.hijoIzq.agregarElemento(x);
                balancear(this);
            } else if (nodo.raiz < x) {
                nodo.hijoDer.agregarElemento(x);
                balancear(this);
            }
        }
    }

    @Override
    public boolean arbolVacio() {
        return (nodo == null);
    }

    @Override
    public void eliminarElemento(int x) {
        if (nodo != null) {
            if (nodo.raiz == x) {
                if (nodo.hijoIzq.arbolVacio() && nodo.hijoDer.arbolVacio()) {
                    nodo = null;
                    System.out.println("Elimino:" + x);
                } else {
                    if (!nodo.hijoIzq.arbolVacio()) {
                        nodo.raiz = this.mayor(nodo.hijoIzq);
                        nodo.hijoIzq.eliminarElemento(nodo.raiz);
                        balancear(this);
                    } else {
                        nodo.raiz = this.menor(nodo.hijoDer);
                        nodo.hijoDer.eliminarElemento(nodo.raiz);
                        balancear(this);
                    }
                }
            } else if (nodo.raiz > x) {
                nodo.hijoIzq.eliminarElemento(x);
                balancear(this);
            } else {
                nodo.hijoDer.eliminarElemento(x);
                balancear(this);
            }
        }
    }

    @Override
    public ArbolBinarioTDA hijoDer() {
        return nodo.hijoDer;
    }

    @Override
    public ArbolBinarioTDA hijoIzq() {
        return nodo.hijoIzq;
    }

    @Override
    public void inicializarArbol() {
        nodo = null;
    }

    @Override
    public int raiz() {
        return nodo.raiz;
    }

    private int mayor(ArbolBinarioTDA a) {
        if (a.hijoDer().arbolVacio()) {
            return a.raiz();
        } else {
            return mayor(a.hijoDer());
        }
    }

    private int menor(ArbolBinarioTDA arbol) {
        if (arbol.hijoIzq().arbolVacio()) {
            return arbol.raiz();
        } else {
            return menor(arbol.hijoIzq());
        }
    }

    public int getFE() {
        int alturaIzq = altura(this.hijoIzq());
        int alturaDer = altura(this.hijoDer());
        return alturaDer - alturaIzq;
    }

    private int altura(ArbolBinarioTDA a) {
        if (a.arbolVacio()) return -1;
        return 1 + Math.max(altura(a.hijoIzq()), altura(a.hijoDer()));
    }

    private void balancear(AVLImpl a) {
        if (a.getFE() >= 2) {
            System.out.print("Rotacion ");
            if (a.hijoDer().getFE() >= 0) {
                System.out.println("Simple a izquierda ");
                rotarIzq(a);
            } else {
                System.out.println("Doble derecha-izquierda");
                rotarDer(a.hijoDer());
                rotarIzq(a);
            }
        } else if (a.getFE() <= -2) {
            System.out.print("Rotacion ");
            if (a.hijoIzq().getFE() <= 0) {
                System.out.println("Simple a derecha ");
                rotarDer(a);
            } else {
                System.out.println("Doble izquierda-derecha");
                rotarIzq(a.hijoIzq());
                rotarDer(a);
            }
        }
    }

    private void rotarIzq(AVLImpl a) {
        NodoAVL nuevoPadre = a.hijoDer().nodo;
        a.hijoDer().nodo = nuevoPadre.hijoIzq.nodo;
        nuevoPadre.hijoIzq.nodo = a.nodo;
        a.nodo = nuevoPadre;
    }

    private void rotarDer(AVLImpl a) {
        NodoAVL nuevoPadre = a.hijoIzq().nodo;
        a.hijoIzq().nodo = nuevoPadre.hijoDer.nodo;
        nuevoPadre.hijoDer.nodo = a.nodo;
        a.nodo = nuevoPadre;
    }
}