package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioD {
    public static void main(String[] args) {
        TP4EjercicioD app = new TP4EjercicioD();
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
        abb.agregarElemento(6);

        // Calculamos el menor elemento del ABB
        int menor = obtenerMenorElemento(abb);
        System.out.println("El menor elemento del ABB es: " + menor);
    }

    // Método iterativo para obtener el menor elemento en el ABB
    private int obtenerMenorElemento(ArbolBinarioTDA abb) {
        while (!abb.hijoIzq().arbolVacio()) {
            abb = abb.hijoIzq();
        }
        return abb.raiz();
    }
}