package com.uade.app.colasprioridad;

import com.uade.api.ColaPrioridadTDA;
import com.uade.impl.ColaPrioridadTDAImpl;

public class TP1EjercicioB {
    public static void main(String[] args) {
        TP1EjercicioB app = new TP1EjercicioB();
        app.execute();
    }

    private void execute() {
        ColaPrioridadTDA c1 = new ColaPrioridadTDAImpl();
        ColaPrioridadTDA c2 = new ColaPrioridadTDAImpl();

        c1.inicializarCola();
        c2.inicializarCola();

        c1.acolarPrioridad(10, 2);
        c1.acolarPrioridad(20, 1);

        c2.acolarPrioridad(10, 1);
        c2.acolarPrioridad(20, 2);

        boolean resultado = sonIdenticas(c1, c2);

        if (resultado) {
            System.out.println("Son identicas.");
        } else {
            System.out.println("No son identicas.");
        }
    }

    private static boolean sonIdenticas(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
        while (!cp1.colaVacia() && !cp2.colaVacia()) {
            if (cp1.primero() != cp2.primero() || cp1.prioridad() != cp2.prioridad()) {
                return false;
            }
            cp1.desacolar();
            cp2.desacolar();
        }

        return cp1.colaVacia() && cp2.colaVacia();
    }
}
