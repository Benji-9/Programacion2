package com.uade.app.grafos;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.GrafoTDAImpl;

public class TP6Ejercicio8 {
    public static void main(String[] args) {
        TP6Ejercicio8 app = new TP6Ejercicio8();
        app.execute();
    }

    private void execute() {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        grafo.agregarVertices(1);
        grafo.agregarVertices(2);
        grafo.agregarVertices(3);
        grafo.agregarVertices(4);

        grafo.agregarArista(1, 3, 10);
        grafo.agregarArista(3, 2, 20);
        grafo.agregarArista(1, 4, 15);
        grafo.agregarArista(4, 2, 25);

        int v1 = 1;
        int v2 = 2;

        ConjuntoTDA puentes = obtenerPuentes(grafo, v1, v2);

        System.out.println("Vertices puente entre " + v1 + " y " + v2 + ":");
        while (!puentes.conjuntoVacio()) {
            int puente = puentes.elegir();
            System.out.print(puente + " ");
            puentes.sacar(puente);
        }
    }

    private ConjuntoTDA obtenerPuentes(GrafoTDA grafo, int v1, int v2) {
        ConjuntoTDA puentes = new ConjuntoTDAImpl();
        puentes.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int p = vertices.elegir();
            vertices.sacar(p);

            if (grafo.existeArista(v1, p) && grafo.existeArista(p, v2)) {
                puentes.agregar(p);
            }
        }

        return puentes;
    }
}