package com.uade.app.colasprioridad;

import com.uade.api.ColaPrioridadTDA;
import com.uade.impl.ColaPrioridadTDAImpl;

public class TP1EjercicioA {
    public static void main(String[] args) {
        TP1EjercicioA app = new TP1EjercicioA();
        app.execute();
    }

    private void execute() {
        ColaPrioridadTDA cp1 = new ColaPrioridadTDAImpl();
        ColaPrioridadTDA cp2 = new ColaPrioridadTDAImpl();

        cp1.inicializarCola();
        cp2.inicializarCola();

        cp1.acolarPrioridad(10, 2);
        cp1.acolarPrioridad(20, 1);

        cp2.acolarPrioridad(30, 3);
        cp2.acolarPrioridad(40, 2);

        ColaPrioridadTDA combinada = combinarColas(cp1, cp2);

        while (!combinada.colaVacia()) {
            System.out.println("Elemento: " + combinada.primero() + ", Prioridad: " + combinada.prioridad());
            combinada.desacolar();
        }
    }

    private static ColaPrioridadTDA combinarColas(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
        ColaPrioridadTDA combinada = new ColaPrioridadTDAImpl();
        combinada.inicializarCola();

        while (!cp1.colaVacia() || !cp2.colaVacia()) {
            if (cp1.colaVacia()) {
                // Si cp1 está vacía, sacamos de cp2
                combinada.acolarPrioridad(cp2.primero(), cp2.prioridad());
                cp2.desacolar();
            } else if (cp2.colaVacia()) {
                // Si cp2 está vacía, sacamos de cp1
                combinada.acolarPrioridad(cp1.primero(), cp1.prioridad());
                cp1.desacolar();
            } else {
                // Comparamos las prioridades y acoplamos el que tenga mayor prioridad
                if (cp1.prioridad() >= cp2.prioridad()) {
                    combinada.acolarPrioridad(cp1.primero(), cp1.prioridad());
                    cp1.desacolar();
                } else {
                    combinada.acolarPrioridad(cp2.primero(), cp2.prioridad());
                    cp2.desacolar();
                }
            }
        }

        return combinada;
    }
}