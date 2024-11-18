package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioJ {
    public static void main(String[] args) {
        TP4EjercicioJ app = new TP4EjercicioJ();
        app.execute();
    }

    private void execute() {
        ArbolBinarioTDA abb1 = new ArbolBinarioTDAImplD();
        ArbolBinarioTDA abb2 = new ArbolBinarioTDAImplD();
        abb1.inicializarArbol();
        abb2.inicializarArbol();

        abb1.agregarElemento(15);
        abb1.agregarElemento(10);
        abb1.agregarElemento(20);

        abb2.agregarElemento(15);
        abb2.agregarElemento(10);
        abb2.agregarElemento(20);

        boolean sonIguales = sonArbolesIguales(abb1, abb2);
        System.out.println("Los ABBs son iguales: " + sonIguales);
    }

    private boolean sonArbolesIguales(ArbolBinarioTDA abb1, ArbolBinarioTDA abb2) {
        if (abb1.arbolVacio() && abb2.arbolVacio()) {
            return true;
        }
        if (abb1.arbolVacio() || abb2.arbolVacio() || abb1.raiz() != abb2.raiz()) {
            return false;
        }
        return sonArbolesIguales(abb1.hijoIzq(), abb2.hijoIzq()) && sonArbolesIguales(abb1.hijoDer(), abb2.hijoDer());
    }
}
