package com.uade.impl;

import com.uade.api.ConjuntoTDA;

public class ConjuntoTDAImpl implements ConjuntoTDA {
    private int[] Conjunto; //El contenido del conjunto
    private int cant; //La cantidad de elementos

    public void inicializarConjunto() {
        Conjunto = new int[100];
        cant = 0;
    } //Costo O(1)

    public void agregar(int x) {
        if (!this.pertenece(x)){ //verifica que no pertenezca
            Conjunto[cant] = x;
            cant++; //Suma 1, la cantidad q actua de indice
        }
    }//Costo O(n)

    public int elegir() {
        return Conjunto[cant - 1];
    }//Costo O(1)

    public void sacar(int x) {
        int i = 0;
        while (i < cant && Conjunto[i] != x) {
            i++;
        }
        if (i < cant){ //Elemento encontrado
            Conjunto[i] = Conjunto[cant - 1];
            cant--;
        }
    }//Costo O(n)

    public boolean pertenece(int x) {
        int i = 0;
        while (i < cant && Conjunto[i] != x) {
            i++;
        }
        return (i < cant);
    }//Costo O(n)

    public boolean conjuntoVacio() {
        return (cant == 0);
    }//Costo O(1)
}