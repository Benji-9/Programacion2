package com.uade.impl;

import com.uade.api.ColaPrioridadTDA;

public class ColaPrioridadTDAImpl implements ColaPrioridadTDA {
    int[] elementos; //Los valores de la cola.
    int[] prioridades; //Las prioridades de la cola
    int indice; //La cantidad de elementos

    public void inicializarCola() {
        elementos = new int[100];
        prioridades = new int[100];
        indice = 0;
    }

    public void acolarPrioridad(int x, int p) {
        int j = indice;
        while (j > 0 && prioridades[j-1] > p){
            elementos[j] = elementos[j-1]; //Desplazamiento paralelo
            prioridades[j] = prioridades[j-1]; //Desplazamiento paralelo
            j--;
        }
        elementos[j] = x;
        prioridades[j] = p;
        indice++;
    } //Costo O(n)

    public void desacolar() {
        indice--;
    } //Costo O(1)

    public int primero() {
        return elementos[indice - 1];
    } //Costo O(1)

    public boolean colaVacia() {
        return (indice == 0);
    } //Costo O(1)

    public int prioridad() {
        return prioridades[indice - 1];
    } //Costo O(1)
}
