package com.uade.app.grafos;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.GrafoTDAImpl;

public class TP6Ejercicio6 {
    public static void main(String[] args) {
        TP6Ejercicio6 app = new TP6Ejercicio6();
        app.execute();
    }

    private void execute() {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        // Ejemplo: Inicializar el grafo con vértices y aristas
        grafo.agregarVertices(1);
        grafo.agregarVertices(2);
        grafo.agregarVertices(3);

        grafo.agregarArista(1, 3, 10);
        grafo.agregarArista(2, 3, 20);
        grafo.agregarArista(1, 2, 5);

        int v = 3;

        ConjuntoTDA predecesores = obtenerPredecesores(grafo, v);

        System.out.println("Predecesores del vértice " + v + ":");
        while (!predecesores.conjuntoVacio()) {
            int pred = predecesores.elegir();
            System.out.print(pred + " ");
            predecesores.sacar(pred);
        }
    }

    private ConjuntoTDA obtenerPredecesores(GrafoTDA grafo, int vertice) {
        ConjuntoTDA predecesores = new ConjuntoTDAImpl();
        predecesores.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int v = vertices.elegir();
            vertices.sacar(v);

            if (grafo.existeArista(v, vertice)) {
                predecesores.agregar(v);
            }
        }

        return predecesores;
    }
}