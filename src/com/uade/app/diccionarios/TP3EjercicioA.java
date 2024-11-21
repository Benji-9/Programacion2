package com.uade.app.diccionarios;

import com.uade.api.DiccionarioMultipleTDA;
import com.uade.impl.DiccionarioMultipleTDAImpl;
import com.uade.api.ConjuntoTDA;
import com.uade.util.OperacionDiccionario;

public class TP3EjercicioA {
    public static void main(String[] args) {
        TP3EjercicioA app = new TP3EjercicioA();
        app.execute();
    }

    private void execute() {
        DiccionarioMultipleTDA D1 = new DiccionarioMultipleTDAImpl();
        DiccionarioMultipleTDA D2 = new DiccionarioMultipleTDAImpl();

        D1.inicializarDiccionario();
        D2.inicializarDiccionario();

        D1.agregar(1, 10);
        D1.agregar(1, 20);
        D1.agregar(2, 30);
        D1.agregar(3, 40);

        D2.agregar(1, 20);
        D2.agregar(1, 50);
        D2.agregar(3, 40);
        D2.agregar(4, 60);

        DiccionarioMultipleTDA unionClaves = unionClavesConValores(D1, D2);
        DiccionarioMultipleTDA unionValoresComunes = unionClavesConValoresComunes(D1, D2);
        DiccionarioMultipleTDA clavesComunes = clavesComunesConValores(D1, D2);
        DiccionarioMultipleTDA valoresComunes = clavesComunesConValoresComunes(D1, D2);

        System.out.println("Union de claves con todos los valores:");
        OperacionDiccionario.mostrarDiccionario(unionClaves);

        System.out.println("Union de claves con valores comunes:");
        OperacionDiccionario.mostrarDiccionario(unionValoresComunes);

        System.out.println("Claves comunes con todos los valores:");
        OperacionDiccionario.mostrarDiccionario(clavesComunes);

        System.out.println("Claves comunes con valores comunes:");
        OperacionDiccionario.mostrarDiccionario(valoresComunes);
    }

    private DiccionarioMultipleTDA unionClavesConValores(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleTDAImpl();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesD1 = D1.claves();
        while (!clavesD1.conjuntoVacio()) {
            int clave = clavesD1.elegir();
            copiarValores(D1, resultado, clave);
            clavesD1.sacar(clave);
        }

        ConjuntoTDA clavesD2 = D2.claves();
        while (!clavesD2.conjuntoVacio()) {
            int clave = clavesD2.elegir();
            copiarValores(D2, resultado, clave);
            clavesD2.sacar(clave);
        }

        return resultado;
    }

    private DiccionarioMultipleTDA unionClavesConValoresComunes(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleTDAImpl();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesD1 = D1.claves();
        while (!clavesD1.conjuntoVacio()) {
            int clave = clavesD1.elegir();
            if (!D2.recuperar(clave).conjuntoVacio()) {
                ConjuntoTDA valoresD1 = D1.recuperar(clave);
                ConjuntoTDA valoresD2 = D2.recuperar(clave);

                while (!valoresD1.conjuntoVacio()) {
                    int valor = valoresD1.elegir();
                    if (valoresD2.pertenece(valor)) {
                        resultado.agregar(clave, valor);
                    }
                    valoresD1.sacar(valor);
                }
            }
            clavesD1.sacar(clave);
        }
        return resultado;
    }

    private DiccionarioMultipleTDA clavesComunesConValores(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleTDAImpl();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesD1 = D1.claves();
        while (!clavesD1.conjuntoVacio()) {
            int clave = clavesD1.elegir();
            if (!D2.recuperar(clave).conjuntoVacio()) {
                copiarValores(D1, resultado, clave);
                copiarValores(D2, resultado, clave);
            }
            clavesD1.sacar(clave);
        }
        return resultado;
    }

    private DiccionarioMultipleTDA clavesComunesConValoresComunes(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleTDAImpl();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesD1 = D1.claves();
        while (!clavesD1.conjuntoVacio()) {
            int clave = clavesD1.elegir();
            if (!D2.recuperar(clave).conjuntoVacio()) {
                ConjuntoTDA valoresD1 = D1.recuperar(clave);
                ConjuntoTDA valoresD2 = D2.recuperar(clave);

                while (!valoresD1.conjuntoVacio()) {
                    int valor = valoresD1.elegir();
                    if (valoresD2.pertenece(valor)) {
                        resultado.agregar(clave, valor);
                    }
                    valoresD1.sacar(valor);
                }
            }
            clavesD1.sacar(clave);
        }
        return resultado;
    }

    private void copiarValores(DiccionarioMultipleTDA origen, DiccionarioMultipleTDA destino, int clave) {
        ConjuntoTDA valores = origen.recuperar(clave);
        while (!valores.conjuntoVacio()) {
            int valor = valores.elegir();
            destino.agregar(clave, valor);
            valores.sacar(valor);
        }
    }
}