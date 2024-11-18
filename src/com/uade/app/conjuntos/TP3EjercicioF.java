package com.uade.app.conjuntos;

import com.uade.api.ColaTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionConjunto;

public class TP3EjercicioF {
    public static void main(String[] args) {
        TP3EjercicioF app = new TP3EjercicioF();
        app.execute();
    }
    private void execute() {
        PilaTDA P = new PilaTDAImpl();
        ColaTDA C = new ColaTDAImpl();

        P.inicializarPila();
        C.inicializarCola();

        P.apilar(1);
        P.apilar(2);
        P.apilar(3);

        C.acolar(3);
        C.acolar(2);
        C.acolar(1);

        boolean sonIguales = elementosPilaIgualesCola(P, C);

        System.out.println("¿Los elementos de la Pila P y la Cola C son los mismos? " + (sonIguales ? "Sí" : "No"));
    }

    private static boolean elementosPilaIgualesCola(PilaTDA P, ColaTDA C) {
        ConjuntoTDA conjuntoPila = generarConjuntoDesdePila(P);
        ConjuntoTDA conjuntoCola = generarConjuntoDesdeCola(C);

        return conjuntosIguales(conjuntoPila, conjuntoCola);
    }

    private static ConjuntoTDA generarConjuntoDesdePila(PilaTDA P) {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        PilaTDA auxPila = new PilaTDAImpl();
        auxPila.inicializarPila();

        while (!P.pilaVacia()) {
            int elemento = P.tope();
            conjunto.agregar(elemento);
            auxPila.apilar(elemento); // Guardamos los elementos en la pila auxiliar
            P.desapilar();
        }

        while (!auxPila.pilaVacia()) {
            int elemento = auxPila.tope();
            P.apilar(elemento);
            auxPila.desapilar();
        }

        return conjunto;
    }

    private static ConjuntoTDA generarConjuntoDesdeCola(ColaTDA C) {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        ColaTDA auxCola = new ColaTDAImpl();
        auxCola.inicializarCola();

        while (!C.colaVacia()) {
            int elemento = C.primero();
            conjunto.agregar(elemento);
            auxCola.acolar(elemento); // Guardamos los elementos en la cola auxiliar
            C.desacolar();
        }

        while (!auxCola.colaVacia()) {
            int elemento = auxCola.primero();
            C.acolar(elemento);
            auxCola.desacolar();
        }

        return conjunto;
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
