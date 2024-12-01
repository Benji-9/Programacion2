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
        ConjuntoTDA a = new ConjuntoTDAImpl();
        ConjuntoTDA b = new ConjuntoTDAImpl();

        a.inicializarConjunto();
        b.inicializarConjunto();

        a.agregar(1);
        a.agregar(2);
        a.agregar(3);
        b.agregar(3);
        b.agregar(4);
        b.agregar(5);

        ConjuntoTDA diferenciaSimetrica = calcularDiferenciaSimetrica(a, b);

        System.out.println("Diferencia simétrica entre A y B:");
        OperacionConjunto.mostrarConjunto(diferenciaSimetrica);
    }

    private static ConjuntoTDA calcularDiferenciaSimetrica(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA resultado = new ConjuntoTDAImpl();
        resultado.inicializarConjunto();

        ConjuntoTDA tempA = OperacionConjunto.copiarConjunto(a);
        ConjuntoTDA tempB = OperacionConjunto.copiarConjunto(b);

        while (!tempA.conjuntoVacio()) {
            int elemento = tempA.elegir();
            tempA.sacar(elemento);
            if (!b.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        while (!tempB.conjuntoVacio()) {
            int elemento = tempB.elegir();
            tempB.sacar(elemento);
            if (!a.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        return resultado;
    }
}