package com.uade.app.grafos;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.GrafoTDAImpl;

public class TP6Ejercicio7 {
    public static void main(String[] args) {
        TP6Ejercicio7 app = new TP6Ejercicio7();
        app.execute();
    }

    private void execute() {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        grafo.agregarVertices(1);
        grafo.agregarVertices(2);
        grafo.agregarVertices(3);
        grafo.agregarVertices(4);

        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(2, 3, 20);

        ConjuntoTDA aislados = obtenerVerticesAislados(grafo);

        System.out.println("Vertices aislados:");
        while (!aislados.conjuntoVacio()) {
            int vertice = aislados.elegir();
            System.out.print(vertice + " ");
            aislados.sacar(vertice);
        }
    }

    private ConjuntoTDA obtenerVerticesAislados(GrafoTDA grafo) {
        ConjuntoTDA aislados = new ConjuntoTDAImpl();
        aislados.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int v = vertices.elegir();
            vertices.sacar(v);

            if (esAislado(grafo, v)) {
                aislados.agregar(v);
            }
        }

        return aislados;
    }

    private boolean esAislado(GrafoTDA grafo, int vertice) {
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int otroVertice = vertices.elegir();
            vertices.sacar(otroVertice);

            if (grafo.existeArista(vertice, otroVertice) || grafo.existeArista(otroVertice, vertice)) {
                return false; // falso, si tiene entradas y/o salidas
            }
        }

        return true; // true si no contiene aristas
    }
}