package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioI {
    public static void main(String[] args) {
        TP4EjercicioI app = new TP4EjercicioI();
        app.execute();
    }

    private void execute() {
        ArbolBinarioTDA abb1 = new ArbolBinarioTDAImplD();
        ArbolBinarioTDA abb2 = new ArbolBinarioTDAImplD();
        abb1.inicializarArbol();
        abb2.inicializarArbol();

        // Insertamos algunos elementos en los ABBs
        abb1.agregarElemento(15);
        abb1.agregarElemento(10);
        abb1.agregarElemento(20);

        abb2.agregarElemento(15);
        abb2.agregarElemento(10);
        abb2.agregarElemento(20);

        // Comprobamos si los ABB tienen la misma forma
        boolean mismaForma = tienenMismaForma(abb1, abb2);
        System.out.println("Los ABBs tienen la misma forma: " + mismaForma);
    }

    // Método recursivo para comprobar si dos ABB tienen la misma forma
    private boolean tienenMismaForma(ArbolBinarioTDA abb1, ArbolBinarioTDA abb2) {
        if (abb1.arbolVacio() && abb2.arbolVacio()) {
            return true;
        }
        if (abb1.arbolVacio() || abb2.arbolVacio()) {
            return false;
        }
        return tienenMismaForma(abb1.hijoIzq(), abb2.hijoIzq()) && tienenMismaForma(abb1.hijoDer(), abb2.hijoDer());
    }
}
