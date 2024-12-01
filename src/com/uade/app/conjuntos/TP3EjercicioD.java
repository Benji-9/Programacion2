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
        ConjuntoTDA a = new ConjuntoTDAImpl();
        a.inicializarConjunto();

        a.agregar(1);
        a.agregar(2);
        a.agregar(3);

        int cardinalidad = calcularCardinalidad(a);
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