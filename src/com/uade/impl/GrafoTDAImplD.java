package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;

public class GrafoTDAImplD implements GrafoTDA {
    class NodoGrafo{
        int nodo;
        NodoArista arista;
        NodoGrafo sigNodo;
    }

    class NodoArista{
        int etiqueta;
        NodoGrafo nodoDestino;
        NodoArista sigArista;
    }

    NodoGrafo origen;

    public void inicializarGrafo() {
        origen = null;
    }

    public void agregarVertices(int v) {
        NodoGrafo aux = new NodoGrafo();
        aux.nodo = v;
        aux.arista = null;
        aux.sigNodo = origen;
        origen = aux;
    }

    public void eliminarVertices(int v) {
        if (origen.nodo == v){
            origen = origen.sigNodo;
        }
        NodoGrafo aux = origen;
        while (aux != null){
            this.eliminarAristaNodo(aux, v);
            if (aux.sigNodo != null && aux.sigNodo.nodo == v){
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    private void eliminarAristaNodo(NodoGrafo n, int v) {
        NodoArista aux = n.arista;
        if (aux != null){
            if (aux.nodoDestino.nodo == v){
                n.arista = aux.sigArista;
            } else {
                while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v){
                    aux = aux.sigArista;
                }
                if (aux.sigArista != null){
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

    private NodoGrafo Vert2Nodo(int v) {
        NodoGrafo aux = origen;
        while (aux != null && aux.nodo != v){
            aux = aux.sigNodo;
        }
        return aux;
    }

    public ConjuntoTDA vertices() {
        ConjuntoTDA c = new ConjuntoTDAImpl();
        NodoGrafo aux = origen;
        while (aux != null){
            c.agregar(aux.nodo);
            aux = aux.sigNodo;
        }
        return c;
    }

    public void agregarArista(int v1, int v2, int peso) {
        NodoGrafo n1 = new NodoGrafo();
        NodoGrafo n2 = new NodoGrafo();

        NodoArista aux = new NodoArista();
        aux.etiqueta = peso;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }

    public void eliminarArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        eliminarAristaNodo(n1, v2);
    }

    public boolean existeArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux != null && aux.nodoDestino.nodo != v2){
            aux = aux.sigArista;
        }
        return aux != null;
    }

    public int pesoArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux.nodoDestino.nodo != v2){
            aux = aux.sigArista;
        }
        return aux.etiqueta;
    }
}