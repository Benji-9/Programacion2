package com.uade.app.conjuntos;

import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.util.OperacionConjunto;

public class TP3EjercicioA {
    public static void main(String[] args) {
        TP3EjercicioA app = new TP3EjercicioA();
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
        B.agregar(3);
        B.agregar(4);
        B.agregar(5);

        ConjuntoTDA diferenciaSimetrica = calcularDiferenciaSimetrica(A, B);

        System.out.println("Diferencia simétrica entre A y B:");
        OperacionConjunto.mostrarConjunto(diferenciaSimetrica);
    }

    private static ConjuntoTDA calcularDiferenciaSimetrica(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA resultado = new ConjuntoTDAImpl();
        resultado.inicializarConjunto();

        ConjuntoTDA tempA = OperacionConjunto.copiarConjunto(A);
        ConjuntoTDA tempB = OperacionConjunto.copiarConjunto(B);

        while (!tempA.conjuntoVacio()) {
            int elemento = tempA.elegir();
            tempA.sacar(elemento);
            if (!B.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        while (!tempB.conjuntoVacio()) {
            int elemento = tempB.elegir();
            tempB.sacar(elemento);
            if (!A.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        return resultado;
    }
}