package com.uade.impl;

import com.uade.api.ColaTDA;

public class ColaTDAImplDos implements ColaTDA {
    int[] arr;
    int inx;

    public void inicializarCola() {
        arr = new int[100];
        inx = 0;
    }

    public void acolar(int x) {
        for (int i = inx - 1;i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = x;
        inx++;
    } //Costo O(n)

    public void desacolar() {
        inx--;
    } //Costo O(1)

    public int primero() {
        return arr[inx - 1];
    } //Costo O(1)

    public boolean colaVacia() {
        return (inx == 0);
    } //Costo O(1)
}
