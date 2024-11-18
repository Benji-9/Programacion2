package com.uade.app.conjuntos;

import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.util.OperacionConjunto;

public class TP1EjercicioF {

    public static void main(String[] args) {
        TP1EjercicioF app = new TP1EjercicioF();
        app.execute();
    }

    private void execute() {
        ConjuntoTDA c1 = new ConjuntoTDAImpl();
        ConjuntoTDA c2 = new ConjuntoTDAImpl();
        ConjuntoTDA c3 = new ConjuntoTDAImpl();
        ConjuntoTDA c4 = new ConjuntoTDAImpl();
        ConjuntoTDA c5 = new ConjuntoTDAImpl();
        ConjuntoTDA c6 = new ConjuntoTDAImpl();

        c1.inicializarConjunto();
        c2.inicializarConjunto();
        c3.inicializarConjunto();
        c4.inicializarConjunto();
        c5.inicializarConjunto();
        c6.inicializarConjunto();

        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);

        c3.agregar(1);
        c3.agregar(2);
        c3.agregar(3);

        c4.agregar(3);
        c4.agregar(4);
        c4.agregar(5);

        c5.agregar(1);
        c5.agregar(2);
        c5.agregar(3);

        c6.agregar(3);
        c6.agregar(4);
        c6.agregar(5);

        ConjuntoTDA interseccionResultado = OperacionConjunto.interseccion(c1, c2);
        System.out.println("Intersección:");
        while (!interseccionResultado.conjuntoVacio()) {
            int elemento = interseccionResultado.elegir();
            System.out.println(elemento);
            interseccionResultado.sacar(elemento);
        }

        ConjuntoTDA unionResultado = OperacionConjunto.union(c3, c4);
        System.out.println("Unión:");
        while (!unionResultado.conjuntoVacio()) {
            int elemento = unionResultado.elegir();
            System.out.println(elemento);
            unionResultado.sacar(elemento);
        }

        ConjuntoTDA diferenciaResultado = OperacionConjunto.diferencia(c5, c6);
        System.out.println("Diferencia (c1 - c2):");
        while (!diferenciaResultado.conjuntoVacio()) {
            int elemento = diferenciaResultado.elegir();
            System.out.println(elemento);
            diferenciaResultado.sacar(elemento);
        }
    }
}