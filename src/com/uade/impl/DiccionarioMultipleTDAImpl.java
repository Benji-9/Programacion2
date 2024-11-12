package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioMultipleTDA;

public class DiccionarioMultipleTDAImpl implements DiccionarioMultipleTDA {
    static class Elemento {
        int clave;
        int[] valores;
        int cantValores;
    }

    private Elemento[] elementos;
    private int cantClaves;

    public void inicializarDiccionario() {
        elementos = new Elemento[100]; // Array de elementos (claves)
        cantClaves = 0; // Inicializamos la cantidad de claves
    }

    public void agregar(int clave, int valor) {
        int PosC = Clave2Indice(clave);
        if (PosC == -1) { // Si la clave no existe, se crea
            PosC = cantClaves;
            elementos[PosC] = new Elemento();
            elementos[PosC].clave = clave;
            elementos[PosC].cantValores = 0;
            elementos[PosC].valores = new int[100]; // Array de valores asociado a la clave
            cantClaves++;
        }

        Elemento e = elementos[PosC];
        int PosV = Valor2Indice(e, valor);
        if (PosV == -1) { // Si el valor no existe en el conjunto, lo agregamos
            e.valores[e.cantValores] = valor;
            e.cantValores++;
        }
    }

    public void eliminar(int clave) {
        int PosC = Clave2Indice(clave);
        if (PosC != -1) {
            elementos[PosC] = elementos[cantClaves - 1]; // Reemplazamos con el último elemento
            cantClaves--; // Disminuimos la cantidad de claves
        }
    }

    public void eliminarValor(int clave, int valor) {
        int posC = Clave2Indice(clave);
        if (posC != -1) {
            Elemento e = elementos[posC];
            int posV = Valor2Indice(e, valor);
            if (posV != -1) { // Corregido: Verificamos si el valor existe
                e.valores[posV] = e.valores[e.cantValores - 1]; // Reemplazamos con el último valor
                e.cantValores--; // Disminuimos la cantidad de valores
            }
            if (e.cantValores == 0) { // Si ya no quedan valores, eliminamos la clave
                eliminar(clave);
            }
        }
    }

    private int Clave2Indice(int clave) {
        int i = cantClaves - 1;
        while (i >= 0 && elementos[i].clave != clave) {
            i--;
        }
        return i;
    }

    private int Valor2Indice(Elemento e, int valor) {
        int i = e.cantValores - 1;
        while (i >= 0 && e.valores[i] != valor) {
            i--;
        }
        return i;
    }

    public ConjuntoTDA recuperar(int clave) {
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        int posC = Clave2Indice(clave);
        if (posC != -1) { // Si la clave existe
            Elemento e = elementos[posC];
            for (int i = 0; i < e.cantValores; i++) {
                c.agregar(e.valores[i]); // Agregamos los valores al conjunto
            }
        }
        return c;
    }

    public ConjuntoTDA claves() {
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        for (int i = 0; i < cantClaves; i++) {
            c.agregar(elementos[i].clave); // Agregamos todas las claves al conjunto
        }
        return c;
    }
}