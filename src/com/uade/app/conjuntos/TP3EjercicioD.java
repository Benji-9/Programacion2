package com.uade.app.conjuntos;

import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.util.OperacionConjunto;

public class TP3EjercicioD {
    public static void main(String[] args) {
        TP3EjercicioD app = new TP3EjercicioD();
        app.execute();
    }

    private void execute() {
        ConjuntoTDA A = new ConjuntoTDAImpl();
        A.inicializarConjunto();

        A.agregar(1);
        A.agregar(2);
        A.agregar(3);

        int cardinalidad = calcularCardinalidad(A);
        System.out.println("Cardinalidad del conjunto A: " + cardinalidad);
    }

    private static int calcularCardinalidad(ConjuntoTDA conjunto) {
        int contador = 0;
        ConjuntoTDA temp = OperacionConjunto.copiarConjunto(conjunto);

        while (!temp.conjuntoVacio()) {
            int elemento = temp.elegir();
            temp.sacar(elemento);
            contador++;
        }

        return contador;
    }
}