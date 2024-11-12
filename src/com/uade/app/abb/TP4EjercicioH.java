package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioH {
    public static void main(String[] args) {
        TP4EjercicioH app = new TP4EjercicioH();
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

        // Calculamos la altura del ABB
        int altura = calcularAltura(abb);
        System.out.println("La altura del ABB es: " + altura);
    }

    // Método recursivo para calcular la altura del ABB
    private int calcularAltura(ArbolBinarioTDA abb) {
        if (abb.arbolVacio()) {
            return -1;
        }
        return 1 + Math.max(calcularAltura(abb.hijoIzq()), calcularAltura(abb.hijoDer()));
    }
}