package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioSimpleTDA;

public class DiccionarioSimpleTDAImpl implements DiccionarioSimpleTDA {
    static class Elemento{
        public int clave;
        public int valor;
    }
        private Elemento[] elementos;
        private int cant;

    public void inicializarDiccionario() {
        elementos = new Elemento[100];
        cant++;
    }

    public void agregar(int clave, int valor) {
        int pos = Clave2Indice(clave);
        if (pos == -1){
            pos = cant;
            elementos[pos] = new Elemento();
            elementos[pos].clave = clave;
            cant++;
        }
        elementos[pos].valor = valor;
    }

    private int Clave2Indice(int clave) {
        int i = cant - 1;
        while (i >= 0 && elementos[i].clave != clave) {
            i--;
        }
        return i;
    }

    public void eliminar(int clave) {
        int pos = Clave2Indice(clave);
        if (pos != -1){
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    public int recuperar(int clave) {
        int pos = Clave2Indice(clave);
        return elementos[pos].valor;
    }

    public ConjuntoTDA claves() {
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        for (int i = 0; i < cant; i++){
            c.agregar(elementos[i].clave);
        }
        return c;
    }
}
