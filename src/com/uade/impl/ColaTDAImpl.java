package com.uade.impl;

import com.uade.api.ColaTDA;

public class ColaTDAImpl implements ColaTDA {
    int[] arr;
    int inx;

    public void inicializarCola() {
        arr = new int[100];
        inx = 0;
    }

    public void acolar(int x) {
        arr[inx] = x;
        inx++;
    } //Costo O(1)

    public void desacolar() {
        for (int i = 0; i < inx - 1; i++){
            arr[i] = arr[i+1];
        }
        inx--;
    } //Costo O(n)

    public int primero() {
        return arr[0];
    } //Costo O(1)

    public boolean colaVacia() {
        return (inx==0);
    } //Costo O(1)
}