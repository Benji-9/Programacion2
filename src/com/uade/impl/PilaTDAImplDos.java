package com.uade.impl;

import com.uade.api.PilaTDA;

public class PilaTDAImplDos implements PilaTDA {
    int[] arr;
    int inx;

    public void inicializarPila() {
        arr = new int[100];
        inx = 0;
    }

    public void apilar(int x) {
        for (int i= inx - 1; i >= 0; i--) {
            arr[i+1] = arr[i];
        }
        arr[0] = x;
        inx++;
    } //Costo O(n)

    public void desapilar() {
        for (int i = 0; i < inx; i++) {
            arr[i] = arr[i+1];
        }
        inx--;
    } //Costo O(n)

    public int tope() {
        return arr[0];
    } //Costo O(1)

    public boolean pilaVacia() {
        return (inx == 0);
    } //Costo O(1)
}
