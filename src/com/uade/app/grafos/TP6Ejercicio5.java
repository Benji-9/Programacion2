package com.uade.app.grafos;

import com.uade.api.GrafoTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.impl.GrafoTDAImpl;

public class TP6Ejercicio5 {
    public static void main(String[] args) {
        TP6Ejercicio5 app = new TP6Ejercicio5();
        app.execute();
    }

    private void execute() {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        // Ejemplo: Inicializar el grafo con vértices y aristas
        grafo.agregarVertices(1);
        grafo.agregarVertices(2);
        grafo.agregarVertices(3);

        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(1, 3, 20);
        grafo.agregarArista(2, 3, 5);

        int vertice = 1; // Vértice del cual calcular el mayor costo de aristas salientes
        int maxCosto = calcularMayorCostoAristasSalientes(grafo, vertice);

        if (maxCosto == -1) {
            System.out.println("El vértice " + vertice + " no tiene aristas salientes.");
        } else {
            System.out.println("El mayor costo de las aristas salientes del vértice " + vertice + " es: " + maxCosto);
        }
    }

    private int calcularMayorCostoAristasSalientes(GrafoTDA grafo, int vertice) {
        int maxCosto = -1;
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int v = vertices.elegir();
            vertices.sacar(v);

            if (grafo.existeArista(vertice, v)) {
                int peso = grafo.pesoArista(vertice, v);
                if (maxCosto == -1 || peso > maxCosto) {
                    maxCosto = peso;
                }
            }
        }

        return maxCosto;
    }
}