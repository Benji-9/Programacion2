package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioE {
    public static void main(String[] args) {
        TP4EjercicioE app = new TP4EjercicioE();
        app.execute();
    }

    private void execute() {
        ArbolBinarioTDA abb = new ArbolBinarioTDAImplD();
        abb.inicializarArbol();

        // Insertamos algunos elementos en el ABB
        abb.agregarElemento(15);
        abb.agregarElemento(10);
        abb.agregarElemento(20);
        abb.agregarElemento(8);
        abb.agregarElemento(12);

        // Calculamos la cantidad de elementos del ABB
        int cantidad = contarElementos(abb);
        System.out.println("La cantidad de elementos en el ABB es: " + cantidad);
    }

    // Método recursivo para contar la cantidad de elementos en el ABB
    private int contarElementos(ArbolBinarioTDA abb) {
        if (abb.arbolVacio()) {
            return 0;
        }
        return 1 + contarElementos(abb.hijoIzq()) + contarElementos(abb.hijoDer());
    }
}