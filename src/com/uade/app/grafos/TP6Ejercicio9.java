package com.uade.app.grafos;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;
import com.uade.impl.GrafoTDAImpl;
import com.uade.util.OperacionConjunto;

public class TP6Ejercicio9 {
    public static void main(String[] args) {
        TP6Ejercicio9 app = new TP6Ejercicio9();
        app.execute();
    }

    private void execute() {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        grafo.agregarVertices(1);
        grafo.agregarVertices(2);
        grafo.agregarVertices(3);

        grafo.agregarArista(1, 2, 5);
        grafo.agregarArista(2, 3, 10);
        grafo.agregarArista(3, 1, 15);
        grafo.agregarArista(1, 3, 20);

        int v = 1;
        int grado = calcularGrado(grafo, v);

        System.out.println("El grado del vértice " + v + " es: " + grado);
    }

    private int calcularGrado(GrafoTDA grafo, int v) {
        ConjuntoTDA vertices = grafo.vertices();

        int salientes = 0;
        int entrantes = 0;

        ConjuntoTDA temp = OperacionConjunto.copiarConjunto(vertices);
        while (!temp.conjuntoVacio()) {
            int destino = temp.elegir();
            temp.sacar(destino);

            if (grafo.existeArista(v, destino)) {
                salientes++;
            }
        }

        temp = OperacionConjunto.copiarConjunto(vertices);
        while (!temp.conjuntoVacio()) {
            int origen = temp.elegir();
            temp.sacar(origen);

            if (grafo.existeArista(origen, v)) {
                entrantes++;
            }
        }

        return salientes - entrantes;
    }

}