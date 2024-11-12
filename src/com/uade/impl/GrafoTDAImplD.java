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

    }

    public void eliminarVertices(int v) {

    }

    public ConjuntoTDA vertices() {
        return null;
    }

    public void agregarArista(int v1, int v2, int peso) {

    }

    public void eliminarArista(int v1, int v2) {

    }

    public boolean existeArista(int v1, int v2) {
        return false;
    }

    public int pesoArista(int v1, int v2) {
        return 0;
    }
}
