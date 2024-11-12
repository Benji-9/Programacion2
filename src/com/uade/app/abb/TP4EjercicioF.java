package com.uade.app.abb;

import com.uade.api.ArbolBinarioTDA;
import com.uade.impl.ArbolBinarioTDAImplD;

public class TP4EjercicioF {
    public static void main(String[] args) {
        TP4EjercicioF app = new TP4EjercicioF();
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

        // Calculamos la suma de los elementos del ABB
        int suma = sumarElementos(abb);
        System.out.println("La suma de los elementos en el ABB es: " + suma);
    }

    // Método recursivo para calcular la suma de los elementos en el ABB
    private int sumarElementos(ArbolBinarioTDA abb) {
        if (abb.arbolVacio()) {
            return 0;
        }
        return abb.raiz() + sumarElementos(abb.hijoIzq()) + sumarElementos(abb.hijoDer());
    }
}