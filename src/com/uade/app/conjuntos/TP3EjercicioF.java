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
        PilaTDA p = new PilaTDAImpl();
        ColaTDA c = new ColaTDAImpl();

        p.inicializarPila();
        c.inicializarCola();

        p.apilar(1);
        p.apilar(2);
        p.apilar(3);

        c.acolar(3);
        c.acolar(2);
        c.acolar(1);

        boolean sonIguales = elementosPilaIgualesCola(p, c);

        System.out.println("¿Los elementos de la Pila P y la Cola C son los mismos? " + (sonIguales ? "Sí" : "No"));
    }

    private static boolean elementosPilaIgualesCola(PilaTDA P, ColaTDA C) {
        ConjuntoTDA conjuntoPila = generarConjuntoDesdePila(P);
        ConjuntoTDA conjuntoCola = generarConjuntoDesdeCola(C);

        return conjuntosIguales(conjuntoPila, conjuntoCola);
    }

    private static ConjuntoTDA generarConjuntoDesdePila(PilaTDA p) {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        PilaTDA auxPila = new PilaTDAImpl();
        auxPila.inicializarPila();

        while (!p.pilaVacia()) {
            int elemento = p.tope();
            conjunto.agregar(elemento);
            auxPila.apilar(elemento); // Guardamos los elementos en la pila auxiliar
            p.desapilar();
        }

        while (!auxPila.pilaVacia()) {
            int elemento = auxPila.tope();
            p.apilar(elemento);
            auxPila.desapilar();
        }

        return conjunto;
    }

    private static ConjuntoTDA generarConjuntoDesdeCola(ColaTDA c) {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        ColaTDA auxCola = new ColaTDAImpl();
        auxCola.inicializarCola();

        while (!c.colaVacia()) {
            int elemento = c.primero();
            conjunto.agregar(elemento);
            auxCola.acolar(elemento); // Guardamos los elementos en la cola auxiliar
            c.desacolar();
        }

        while (!auxCola.colaVacia()) {
            int elemento = auxCola.primero();
            c.acolar(elemento);
            auxCola.desacolar();
        }

        return conjunto;
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
