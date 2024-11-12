package com.uade.app.colas;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.util.OperacionCola;

public class TP1EjercicioE {

    public static void main(String[] args) {
        TP1EjercicioE app = new TP1EjercicioE();
        app.execute();
    }

    private void execute() {
        ColaTDA c1 = new ColaTDAImpl();

        c1.inicializarCola();

        c1.acolar(1);
        c1.acolar(2);
        c1.acolar(3);
        c1.acolar(3);
        c1.acolar(2);
        c1.acolar(1);

        boolean resultado = esCapicua(c1);
        if (resultado) {
            System.out.println("La cola es capicua");
        }else {
            System.out.println("La cola no es capicua");
        }
    }

    private static boolean esCapicua(ColaTDA cola) {
        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();
        ColaTDA invertida = new ColaTDAImpl();
        invertida.inicializarCola();

        OperacionCola.copiarEInvertirCapicua(cola, aux, invertida);

        while (!aux.colaVacia() && !invertida.colaVacia()) {
            if (aux.primero() != invertida.primero()) {
                return false;
            }
            aux.desacolar();
            invertida.desacolar();
        }

        return true;
    }
}