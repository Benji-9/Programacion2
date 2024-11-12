package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.api.DiccionarioSimpleTDA;

public class DiccionarioSimpleTDAImplD implements DiccionarioSimpleTDA {
    class NodoClave {
        int clave;
        int valor;
        NodoClave sigClave;
    }

    NodoClave origen;

    public void inicializarDiccionario() {
        origen = null;
    }

    public void agregar(int clave, int valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null) {
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }
        nc.valor = valor;
    }

    public void eliminar(int clave) {
        if (origen != null) {
            if (origen.clave == clave) {
                origen = origen.sigClave;
            } else {
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }
                if (aux.sigClave != null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    public int recuperar(int clave) {
        NodoClave n = Clave2NodoClave(clave);
        return n.valor;
    }

    public ConjuntoTDA claves() {
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        NodoClave aux = origen;
        while (aux != null) {
            c.agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }

    private NodoClave Clave2NodoClave(int clave) {
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sigClave;
        }
        return aux;
    }
}