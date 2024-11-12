package com.uade.app.colas;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.util.OperacionCola;

public class TP1EjercicioF {

    public static void main(String[] args) {
        TP1EjercicioF app = new TP1EjercicioF();
        app.execute();
    }

    private void execute() {
        ColaTDA c1 = new ColaTDAImpl();
        ColaTDA c2 = new ColaTDAImpl();

        c1.inicializarCola();
        c2.inicializarCola();

        c1.acolar(1);
        c1.acolar(2);
        c1.acolar(3);

        c2.acolar(3);
        c2.acolar(2);
        c2.acolar(1);

        boolean resultado = sonInversas(c1, c2);

        if (resultado) {
            System.out.println("Son inversas");
        }else {
            System.out.println("No son Inversas");
        }
    }

    private static boolean sonInversas(ColaTDA C1, ColaTDA C2) {
        // Verificar que las colas tengan el mismo tamaño
        ColaTDA aux1 = new ColaTDAImpl();
        aux1.inicializarCola();
        ColaTDA invertidaC2 = new ColaTDAImpl();
        invertidaC2.inicializarCola();

        // Invertimos C2 en invertida C2
        OperacionCola.copiarEInvertir(C2, invertidaC2);

        // Comparamos los elementos de C1 con los elementos de invertidaC2
        while (!C1.colaVacia() && !invertidaC2.colaVacia()) {
            if (C1.primero() != invertidaC2.primero()) {
                return false; // Si algún elemento es distinto, no son inversas
            }
            C1.desacolar();
            invertidaC2.desacolar();
        }

        // Si ambas colas están vacías, eran inversas; de lo contrario, no lo son
        return C1.colaVacia() && invertidaC2.colaVacia();
    }
}
