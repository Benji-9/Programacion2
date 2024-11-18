package com.uade.app.grafos;

import com.uade.api.GrafoTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.impl.GrafoTDAImpl;
import com.uade.impl.ConjuntoTDAImpl;

public class TP6Ejercicio4 {
    public static void main(String[] args) {
        TP6Ejercicio4 app = new TP6Ejercicio4();
        app.execute();
    }

    private void execute() {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        grafo.agregarVertices(1);
        grafo.agregarVertices(2);
        grafo.agregarVertices(3);
        grafo.agregarVertices(4);

        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(2, 3, 1);
        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(3, 4, 1);

        ConjuntoTDA adyacentesDobles = adyacentesDobles(grafo, 1);

        while (!adyacentesDobles.conjuntoVacio()) {
            int adyacenteDoble = adyacentesDobles.elegir();
            System.out.println("Adyacente doble de 1: " + adyacenteDoble);
            adyacentesDobles.sacar(adyacenteDoble);
        }
    }

    private ConjuntoTDA adyacentesDobles(GrafoTDA grafo, int v) {
        ConjuntoTDA adyacentesDobles = new ConjuntoTDAImpl();
        adyacentesDobles.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();
        ConjuntoTDA intermedios = new ConjuntoTDAImpl();
        intermedios.inicializarConjunto();

        while (!vertices.conjuntoVacio()) {
            int x = vertices.elegir();
            vertices.sacar(x);

            if (grafo.existeArista(v, x)) {
                intermedios.agregar(x);
            }
        }

        while (!intermedios.conjuntoVacio()) {
            int x = intermedios.elegir();
            intermedios.sacar(x);

            vertices = grafo.vertices();
            while (!vertices.conjuntoVacio()) {
                int w = vertices.elegir();
                vertices.sacar(w);

                if (grafo.existeArista(x, w) && w != v) {
                    adyacentesDobles.agregar(w);
                }
            }
        }
        return adyacentesDobles;
    }
}
