package com.uade.app.colas;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.util.OperacionCola;

public class TP1EjercicioA {

    public static void main(String[] args) {

        TP1EjercicioA app = new TP1EjercicioA();
        app.execute();
    }

    public void execute(){
        ColaTDA origen = new ColaTDAImpl();
        ColaTDA destino = new ColaTDAImpl();

        origen.inicializarCola();
        destino.inicializarCola();

        origen.acolar(1);
        origen.acolar(2);
        origen.acolar(3);

        pasarCola(origen, destino);

        OperacionCola.mostrar(destino);
    }

    private static void pasarCola(ColaTDA origen, ColaTDA destino) {
        while (!origen.colaVacia()) {
            destino.acolar(origen.primero());
            origen.desacolar();
        }
    }
}
