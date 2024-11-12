package com.uade.app.colas;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.util.OperacionCola;

public class TP1EjercicioC {
    public static void main(String[] args) {
        TP1EjercicioC app = new TP1EjercicioC();
        app.execute();
    }

    private void execute() {
        ColaTDA C2 = new ColaTDAImpl();
        OperacionCola op = new OperacionCola();

        C2.inicializarCola();

        C2.acolar(1);
        C2.acolar(2);
        C2.acolar(3);

        invertirSinPila(C2);

        op.mostrar(C2);
    }

    private static void invertirSinPila(ColaTDA cola) {
        if (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            invertirSinPila(cola);
            cola.acolar(elemento);
        }
    }
}
