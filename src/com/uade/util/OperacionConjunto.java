package com.uade.util;

import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoTDAImpl;

public class OperacionConjunto {

    public static ConjuntoTDA interseccion(ConjuntoTDA c1, ConjuntoTDA c2) {
        ConjuntoTDA resultado = new ConjuntoTDAImpl();
        resultado.inicializarConjunto();

        while (!c1.conjuntoVacio()) {
            int elemento = c1.elegir();
            if (c2.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
            c1.sacar(elemento);  // Se extrae el elemento del conjunto para poder iterar.
        }

        return resultado;
    }

    // Unión: Devuelve un conjunto con todos los elementos de ambos conjuntos, sin duplicados.
    public static ConjuntoTDA union(ConjuntoTDA c1, ConjuntoTDA c2) {
        ConjuntoTDA union = new ConjuntoTDAImpl();
        union.inicializarConjunto();

        ConjuntoTDA auxC1 = copiarConjunto(c1);
        ConjuntoTDA auxC2 = copiarConjunto(c2);

        // Agregar todos los elementos del conjunto c1
        while (!auxC1.conjuntoVacio()) {
            int elemento = auxC1.elegir();
            union.agregar(elemento);
            auxC1.sacar(elemento);
        }

        // Agregar todos los elementos del conjunto c2, evitando duplicados
        while (!auxC2.conjuntoVacio()) {
            int elemento = auxC2.elegir();
            if (!union.pertenece(elemento)) { // Evitar duplicados
                union.agregar(elemento);
            }
            auxC2.sacar(elemento);
        }

        return union;
    }

    // Diferencia: Devuelve un conjunto con los elementos que están en c1 pero no en c2.
    public static ConjuntoTDA diferencia(ConjuntoTDA c1, ConjuntoTDA c2) {
        ConjuntoTDA diferencia = new ConjuntoTDAImpl();
        diferencia.inicializarConjunto();

        ConjuntoTDA auxC1 = copiarConjunto(c1);

        while (!auxC1.conjuntoVacio()) {
            int elemento = auxC1.elegir();
            if (!c2.pertenece(elemento)) { // Solo agregamos los que no están en c2
                diferencia.agregar(elemento);
            }
            auxC1.sacar(elemento);
        }

        return diferencia;
    }

    public static ConjuntoTDA copiarConjunto(ConjuntoTDA conjuntoOriginal) {
        ConjuntoTDA copia = new ConjuntoTDAImpl();
        copia.inicializarConjunto();

        ConjuntoTDA aux = new ConjuntoTDAImpl();
        aux.inicializarConjunto();

        while (!conjuntoOriginal.conjuntoVacio()) {
            int elemento = conjuntoOriginal.elegir();
            copia.agregar(elemento);
            aux.agregar(elemento);
            conjuntoOriginal.sacar(elemento);
        }

        // Restaurar el conjunto original
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            conjuntoOriginal.agregar(elemento);
            aux.sacar(elemento);
        }

        return copia;
    }
    public static void mostrarConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA temp = OperacionConjunto.copiarConjunto(conjunto);

        while (!temp.conjuntoVacio()) {
            int elemento = temp.elegir();
            temp.sacar(elemento);
            System.out.println(elemento);
        }
    }
}