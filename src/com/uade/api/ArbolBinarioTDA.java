package com.uade.api;

public interface ArbolBinarioTDA {
    int raiz();
    ArbolBinarioTDA hijoIzq();
    ArbolBinarioTDA hijoDer();
    boolean arbolVacio();
    void inicializarArbol();
    void agregarElemento(int x);
    void eliminarElemento(int x);
}
