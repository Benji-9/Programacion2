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
        PilaTDA p = new PilaTDAImpl();
        ColaTDA c = new ColaTDAImpl();

        p.inicializarPila();
        c.inicializarCola();

        p.apilar(1);
        p.apilar(2);
        p.apilar(3);

        c.acolar(3);
        c.acolar(2);
        c.acolar(4);


        ConjuntoTDA comunes = elementosComunesPilaCola(p, c);

        System.out.println("Elementos comunes entre Pila P y Cola C:");
        OperacionConjunto.mostrarConjunto(comunes);
    }

    private static ConjuntoTDA elementosComunesPilaCola(PilaTDA P, ColaTDA C) {
        ConjuntoTDA conjuntoPila = generarConjuntoDesdePila(P);
        ConjuntoTDA conjuntoCola = generarConjuntoDesdeCola(C);

        return OperacionConjunto.interseccion(conjuntoPila, conjuntoCola);
    }

    private static ConjuntoTDA generarConjuntoDesdePila(PilaTDA p) {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        PilaTDA auxPila = new PilaTDAImpl();
        auxPila.inicializarPila();

        while (!p.pilaVacia()) {
            int elemento = p.tope();
            conjunto.agregar(elemento);
            auxPila.apilar(elemento);
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
            auxCola.acolar(elemento);
            c.desacolar();
        }

        while (!auxCola.colaVacia()) {
            int elemento = auxCola.primero();
            c.acolar(elemento);
            auxCola.desacolar();
        }

        return conjunto;
    }
}