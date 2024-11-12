package com.uade.impl;

import com.uade.api.DiccionarioMultipleTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoTDAImpl;

public class DiccionarioMultipleTDAImplD implements DiccionarioMultipleTDA {
    class NodoClave {
        int clave;
        NodoValor valores; // Origen de este nodo
        NodoClave sigClave;
    }

    class NodoValor {
        int valor;
        NodoValor sigValor;
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
        NodoValor nv = nc.valores;
        while (nv != null && nv.valor != valor) {
            nv = nv.sigValor;
        }
        if (nv == null) {
            nv = new NodoValor();
            nv.valor = valor;
            nv.sigValor = nc.valores;
            nc.valores = nv;
        }
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

    public void eliminarValor(int clave, int valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc != null) {
            EliminarValorEnNodo(nc, valor);
            if (nc.valores == null) {
                eliminar(clave);
            }
        }
    }

    public ConjuntoTDA recuperar(int clave) {
        NodoClave nc = Clave2NodoClave(clave);
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        if (nc != null) {
            NodoValor aux = nc.valores;
            while (aux != null) {
                c.agregar(aux.valor);
                aux = aux.sigValor;
            }
        }
        return c;
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

    private void EliminarValorEnNodo(NodoClave nodo, int valor) {
        if (nodo.valores != null) {
            if (nodo.valores.valor == valor) {
                nodo.valores = nodo.valores.sigValor;
            } else {
                NodoValor aux = nodo.valores;
                while (aux.sigValor != null && aux.sigValor.valor != valor) {
                    aux = aux.sigValor;
                }
                if (aux.sigValor != null) {
                    aux.sigValor = aux.sigValor.sigValor;
                }
            }
        }
    }

    private NodoClave Clave2NodoClave(int clave) {
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sigClave;
        }
        return aux;
    }
}