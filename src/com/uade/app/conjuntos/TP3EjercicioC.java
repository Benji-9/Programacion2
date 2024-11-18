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
        ConjuntoTDA A = new ConjuntoTDAImpl();
        ConjuntoTDA B = new ConjuntoTDAImpl();

        A.inicializarConjunto();
        B.inicializarConjunto();

        A.agregar(1);
        A.agregar(2);
        A.agregar(3);
        B.agregar(1);
        B.agregar(2);
        B.agregar(3);

        boolean sonIguales = conjuntosIguales(A, B);
        System.out.println("¿Son iguales los conjuntos A y B? " + (sonIguales ? "Sí" : "No"));
    }

    private static boolean conjuntosIguales(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA tempA = OperacionConjunto.copiarConjunto(A);
        ConjuntoTDA tempB = OperacionConjunto.copiarConjunto(B);

        while (!tempA.conjuntoVacio()) {
            int elemento = tempA.elegir();
            tempA.sacar(elemento);

            if (!B.pertenece(elemento)) {
                return false;
            }
        }

        while (!tempB.conjuntoVacio()) {
            int elemento = tempB.elegir();
            tempB.sacar(elemento);

            if (!A.pertenece(elemento)) {
                return false;
            }
        }

        return true;
    }
}