package com.uade.app.colas;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.util.OperacionCola;


public class TP1EjercicioD {

    public static void main(String[] args) {
        TP1EjercicioD app = new TP1EjercicioD();
        app.execute();
    }

    private void execute() {
        ColaTDA C1 = new ColaTDAImpl();
        ColaTDA C2 = new ColaTDAImpl();

        C1.inicializarCola();
        C2.inicializarCola();

        C1.acolar(10);
        C1.acolar(11);
        C1.acolar(12);

        C2.acolar(10);
        C2.acolar(11);
        C2.acolar(12);

        boolean resultado = finalCoincide(C1, C2);

        if (resultado) {
            System.out.println("Los finales coinciden");
        } else {
            System.out.println("Los finales no coinciden");
        }
    }

    private static boolean finalCoincide(ColaTDA C1, ColaTDA C2) {
        ColaTDA aux1 = new ColaTDAImpl();
        aux1.inicializarCola();
        OperacionCola.pasarCola(C1, aux1);

        ColaTDA aux2 = new ColaTDAImpl();
        aux2.inicializarCola();
        OperacionCola.pasarCola(C2, aux2);

        while (!aux1.colaVacia() && aux1.primero() != aux2.primero()) {
            aux1.desacolar();
        }

        while (!aux1.colaVacia() && !aux2.colaVacia()) {
            if (aux1.primero() != aux2.primero()) {
                return false;
            }
            aux1.desacolar();
            aux2.desacolar();
        }

        return aux2.colaVacia();
    }
}
