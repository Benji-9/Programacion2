package com.uade.app.conjuntos;

import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.util.OperacionConjunto;

public class TP3EjercicioB {
    public static void main(String[] args) {
        TP3EjercicioB app = new TP3EjercicioB();
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
        // Diferencia simétrica = Unión - Intersección
        ConjuntoTDA union = OperacionConjunto.union(a, b);
        ConjuntoTDA interseccion = OperacionConjunto.interseccion(a, b);
        return OperacionConjunto.diferencia(union, interseccion);
    }
}