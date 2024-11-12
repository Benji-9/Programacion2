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
            System.out.println("Valor: " + clave + " tiene las siguientes prioridades:");

            // Mostramos las prioridades
            while (!prioridades.conjuntoVacio()) {
                int prioridad = prioridades.elegir();
                prioridades.sacar(prioridad);
                System.out.println("  Prioridad: " + prioridad);
            }
        }
    }
}