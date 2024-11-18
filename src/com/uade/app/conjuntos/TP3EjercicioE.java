package com.uade.app.conjuntos;

import com.uade.api.ColaTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionConjunto;

public class TP3EjercicioE {
    public static void main(String[] args) {
        TP3EjercicioE app = new TP3EjercicioE();
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
        C.acolar(4);


        ConjuntoTDA comunes = elementosComunesPilaCola(P, C);

        System.out.println("Elementos comunes entre Pila P y Cola C:");
        OperacionConjunto.mostrarConjunto(comunes);
    }

    private static ConjuntoTDA elementosComunesPilaCola(PilaTDA P, ColaTDA C) {
        ConjuntoTDA conjuntoPila = generarConjuntoDesdePila(P);
        ConjuntoTDA conjuntoCola = generarConjuntoDesdeCola(C);

        return OperacionConjunto.interseccion(conjuntoPila, conjuntoCola);
    }

    private static ConjuntoTDA generarConjuntoDesdePila(PilaTDA P) {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        PilaTDA auxPila = new PilaTDAImpl();
        auxPila.inicializarPila();

        while (!P.pilaVacia()) {
            int elemento = P.tope();
            conjunto.agregar(elemento);
            auxPila.apilar(elemento);
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
            auxCola.acolar(elemento);
            C.desacolar();
        }

        while (!auxCola.colaVacia()) {
            int elemento = auxCola.primero();
            C.acolar(elemento);
            auxCola.desacolar();
        }

        return conjunto;
    }
}