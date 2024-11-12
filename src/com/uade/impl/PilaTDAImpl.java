package com.uade.impl;

import com.uade.api.PilaTDA;

public class PilaTDAImpl implements PilaTDA {
    int[] arr; // Arreglo que contiene la informacion.
    int inx; //Cantidad de elementos en la pila.

    public void inicializarPila() {
        arr = new int[100]; //100 Representar la cantidad maxima de elementos posibles.
        inx = 0;
    }

    public void apilar(int x) {
        arr[inx] = x;
        inx++;
    } //Costo O(1)

    public void desapilar() {
        inx--;
    } //Costo O(1)

    public int tope() {
        return (arr[inx - 1]);
    } //Costo O(1)

    public boolean pilaVacia() {
        return (inx == 0);
    } //Costo O(1)
}