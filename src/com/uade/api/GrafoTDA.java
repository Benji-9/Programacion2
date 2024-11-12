package com.uade.api;

import com.uade.api.ConjuntoTDA;

public interface GrafoTDA {
    void inicializarGrafo();
    void agregarVertices(int v);
    void eliminarVertices(int v);
    ConjuntoTDA vertices();
    void agregarArista(int v1, int v2,int peso);
    void eliminarArista(int v1, int v2);
    boolean existeArista(int v1, int v2);
    int pesoArista(int v1, int v2);

}
