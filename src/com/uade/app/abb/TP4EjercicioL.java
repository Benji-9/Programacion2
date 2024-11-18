package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioL {
    public static void main(String[] args) {
        TP4EjercicioL app = new TP4EjercicioL();
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

        System.out.println("In-orden:");
        mostrarInOrden(abb);
        System.out.println("\nPre-orden:");
        mostrarPreOrden(abb);
        System.out.println("\nPost-orden:");
        mostrarPostOrden(abb);
    }

    private void mostrarInOrden(ArbolBinarioTDA abb) {
        if (!abb.arbolVacio()) {
            mostrarInOrden(abb.hijoIzq());
            System.out.print(abb.raiz() + " ");
            mostrarInOrden(abb.hijoDer());
        }
    }

    private void mostrarPreOrden(ArbolBinarioTDA abb) {
        if (!abb.arbolVacio()) {
            System.out.print(abb.raiz() + " ");
            mostrarPreOrden(abb.hijoIzq());
            mostrarPreOrden(abb.hijoDer());
        }
    }

    private void mostrarPostOrden(ArbolBinarioTDA abb) {
        if (!abb.arbolVacio()) {
            mostrarPostOrden(abb.hijoIzq());
            mostrarPostOrden(abb.hijoDer());
            System.out.print(abb.raiz() + " ");
        }
    }
}
