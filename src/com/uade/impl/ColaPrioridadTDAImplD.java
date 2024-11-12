package com.uade.impl;

import com.uade.api.ColaPrioridadTDA;

public class ColaPrioridadTDAImplD implements ColaPrioridadTDA {
    public class NodoPrioridad {
        int info;
        int prioridad;
        NodoPrioridad sig;
    }
    NodoPrioridad mayorPrioridad;
    public void inicializarCola() {
        mayorPrioridad = null;
    }

    public void acolarPrioridad(int x, int p) {
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.info = x;
        nuevo.prioridad = p;
        if (mayorPrioridad == null || p > mayorPrioridad.prioridad) {
            nuevo.sig = mayorPrioridad;
            mayorPrioridad = nuevo;
        } else {
            NodoPrioridad aux = mayorPrioridad;
            while (aux.sig != null && aux.sig.prioridad >= p) {
                aux = aux.sig;
            }
            nuevo.sig = aux.sig;
            aux.sig = nuevo;
        }
    }

    public void desacolar() {
        mayorPrioridad = mayorPrioridad.sig;
    }

    public int primero() {
        return mayorPrioridad.info;
    }

    public boolean colaVacia() {
        return (mayorPrioridad == null);
    }

    public int prioridad() {
        return mayorPrioridad.prioridad;
    }
}
