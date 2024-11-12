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
        ConjuntoTDA A = new ConjuntoTDAImpl();
        ConjuntoTDA B = new ConjuntoTDAImpl();

        A.inicializarConjunto();
        B.inicializarConjunto();

        // Agregamos elementos a los conjuntos A y B
        A.agregar(1);
        A.agregar(2);
        A.agregar(3);
        B.agregar(3);
        B.agregar(4);
        B.agregar(5);

        // Calculamos la diferencia simétrica
        ConjuntoTDA diferenciaSimetrica = calcularDiferenciaSimetrica(A, B);

        // Mostramos el resultado
        System.out.println("Diferencia simétrica entre A y B:");
        OperacionConjunto.mostrarConjunto(diferenciaSimetrica);
    }

    private static ConjuntoTDA calcularDiferenciaSimetrica(ConjuntoTDA A, ConjuntoTDA B) {
        // Diferencia simétrica = Unión - Intersección
        ConjuntoTDA union = OperacionConjunto.union(A, B);
        ConjuntoTDA interseccion = OperacionConjunto.interseccion(A, B);
        return OperacionConjunto.diferencia(union, interseccion);
    }
}