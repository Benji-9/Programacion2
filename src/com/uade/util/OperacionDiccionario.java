package com.uade.util;

import com.uade.api.DiccionarioMultipleTDA;
import com.uade.api.ConjuntoTDA;

public class OperacionDiccionario {
    public static void mostrarDiccionario(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA claves = diccionario.claves();

        // Recorremos las claves del diccionario
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);

            // Recuperamos los valores asociados a la clave
            ConjuntoTDA prioridades = diccionario.recuperar(clave);
            System.out.println("clave: " + clave + " tiene las siguientes valores:");

            // Mostramos las prioridades
            while (!prioridades.conjuntoVacio()) {
                int prioridad = prioridades.elegir();
                prioridades.sacar(prioridad);
                System.out.println("  valores: " + prioridad);
            }
        }
    }
}