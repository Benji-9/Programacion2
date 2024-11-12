package com.uade.impl;

import com.uade.api.ColaPrioridadTDA;
import com.uade.util.ElementoConjunto;

public class ColaPrioridadTDAImplDos implements ColaPrioridadTDA {
    ElementoConjunto[] elementos;
    int indice;

    public void inicializarCola() {
        elementos = new ElementoConjunto[100];
        indice = 0;
    }

    public void acolarPrioridad(int x, int prioridad) {
        int j = indice;
        // Desplazar elementos según el orden de prioridad
        while (j > 0 && elementos[j - 1].prioridad > prioridad) {
            elementos[j] = elementos[j - 1];
            j--;
        }
        elementos[j] = new ElementoConjunto();
        elementos[j].valor = x;
        elementos[j].prioridad = prioridad;
        indice++;
    } //Costo O(n)

    public void desacolar() {
        indice--;
    } //Costo O(1)

    public int primero() {
        return elementos[indice - 1].valor;
    } //Costo O(1)

    public int prioridad() {
        return elementos[indice - 1].prioridad;
    }//Costo O(1)

    public boolean colaVacia() {
        return (indice == 0);
    }//Costo O(1)
}
