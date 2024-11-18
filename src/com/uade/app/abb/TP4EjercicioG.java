package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioG {
    public static void main(String[] args) {
        TP4EjercicioG app = new TP4EjercicioG();
        app.execute();
    }

    private void execute() {
        ArbolBinarioTDA abb = new ArbolBinarioTDAImplD();
        abb.inicializarArbol();

        abb.agregarElemento(15);
        abb.agregarElemento(10);
        abb.agregarElemento(20);
        abb.agregarElemento(8);
        abb.agregarElemento(12);

        int cantidadHojas = contarHojas(abb);
        System.out.println("La cantidad de hojas en el ABB es: " + cantidadHojas);
    }

    private int contarHojas(ArbolBinarioTDA abb) {
        if (abb.arbolVacio()) {
            return 0;
        }
        if (abb.hijoIzq().arbolVacio() && abb.hijoDer().arbolVacio()) {
            return 1;
        }
        return contarHojas(abb.hijoIzq()) + contarHojas(abb.hijoDer());
    }
}