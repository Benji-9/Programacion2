package com.uade.app.conjuntos;

import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.util.OperacionConjunto;

public class TP3EjercicioC {
    public static void main(String[] args) {
        TP3EjercicioC app = new TP3EjercicioC();
        app.execute();
    }

    private void execute() {
        ConjuntoTDA a = new ConjuntoTDAImpl();
        ConjuntoTDA b = new ConjuntoTDAImpl();

        a.inicializarConjunto();
        b.inicializarConjunto();

        a.agregar(1);
        a.agregar(2);
        a.agregar(3);
        b.agregar(1);
        b.agregar(2);
        b.agregar(3);

        boolean sonIguales = conjuntosIguales(a, b);
        System.out.println("¿Son iguales los conjuntos A y B? " + (sonIguales ? "Sí" : "No"));
    }

    private static boolean conjuntosIguales(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA tempA = OperacionConjunto.copiarConjunto(a);
        ConjuntoTDA tempB = OperacionConjunto.copiarConjunto(b);

        while (!tempA.conjuntoVacio()) {
            int elemento = tempA.elegir();
            tempA.sacar(elemento);

            if (!b.pertenece(elemento)) {
                return false;
            }
        }

        while (!tempB.conjuntoVacio()) {
            int elemento = tempB.elegir();
            tempB.sacar(elemento);

            if (!a.pertenece(elemento)) {
                return false;
            }
        }

        return true;
    }
}