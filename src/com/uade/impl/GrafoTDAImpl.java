package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;

public class GrafoTDAImpl implements GrafoTDA {

    static int n = 100;
    int [][] MAdy;
    int [] Etiqs;
    int cantNodos;

    public void inicializarGrafo() {
        MAdy = new int[n][n];
        Etiqs = new int[n];
        cantNodos = 0;
    }

    public void agregarVertices(int v) {
        if (Vert2Indice(v) == -1){
            Etiqs[cantNodos] = v;
            for (int i=0; i <= cantNodos; i++){
                MAdy[cantNodos][i] = 0;
                MAdy[i][cantNodos] = 0;
            }
            cantNodos++;
        }
    }

    public void eliminarVertices(int v) {
        int ind = Vert2Indice(v);
        for (int i=0; i < cantNodos; i++){
            MAdy[i][ind] = MAdy[i][cantNodos - 1];
        }
        for (int i=0; i < cantNodos; i++){
            MAdy[ind][i] = MAdy[cantNodos - 1][i];
        }
        Etiqs[ind] = Etiqs[cantNodos - 1];
        cantNodos--;
    }

    private int Vert2Indice(int v) {
        int i= cantNodos - 1;
        while (i >= 0 && Etiqs[i] != v){
            i--;
        }
        return i;
    }

    public ConjuntoTDA vertices() {
        ConjuntoTDA vert = new ConjuntoTDAImpl();
        vert.inicializarConjunto();
        for (int i=0; i < cantNodos; i++){
            vert.agregar(Etiqs[i]);
        }
        return vert;
    }

    public void agregarArista(int v1, int v2, int peso) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        MAdy[o][d] = peso;
    }

    public void eliminarArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        MAdy[o][d] = 0;
    }

    public boolean existeArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);

        return MAdy[o][d] != 0;
    }

    public int pesoArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);

        return MAdy[o][d];
    }
}
