package com.uade.app.pilas;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class TP1EjercicioB {
    public static void main(String[] args) {
        TP1EjercicioB app = new TP1EjercicioB();
        app.execute();
    }

    private void execute() {
        PilaTDA p1 = new PilaTDAImpl();
        PilaTDA p2 = new PilaTDAImpl();

        p1.inicializarPila();
        p2.inicializarPila();

        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);

        // Copiar la pila p2 en p3 (mismo orden)
        OperacionPila.copiarPila(p1, p2);

        // Mostrar el contenido de la pila p2 (copia de p1)
        System.out.println("Pila p2 (copia de p1):");
        OperacionPila.mostrar(p2);
    }
}
