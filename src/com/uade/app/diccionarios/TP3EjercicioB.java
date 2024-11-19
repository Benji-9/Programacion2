package com.uade.app.diccionarios;

import com.uade.api.DiccionarioSimpleTDA;
import com.uade.api.DiccionarioMultipleTDA;
import com.uade.impl.DiccionarioSimpleTDAImpl;
import com.uade.impl.DiccionarioMultipleTDAImpl;
import com.uade.api.ConjuntoTDA;
import com.uade.util.OperacionDiccionario;

public class TP3EjercicioB {
    public static void main(String[] args) {
        TP3EjercicioB app = new TP3EjercicioB();
        app.execute();
    }

    private void execute() {
        DiccionarioSimpleTDA D = new DiccionarioSimpleTDAImpl();
        D.inicializarDiccionario();

        D.agregar(1, 100);
        D.agregar(2, 100);
        D.agregar(3, 200);
        D.agregar(4, 300);
        D.agregar(5, 200);

        DiccionarioMultipleTDA DS = generarDiccionarioMultiple(D);

        OperacionDiccionario.mostrarDiccionarioMultiple(DS);
    }

    private DiccionarioMultipleTDA generarDiccionarioMultiple(DiccionarioSimpleTDA D) {
        DiccionarioMultipleTDA DS = new DiccionarioMultipleTDAImpl();
        DS.inicializarDiccionario();

        ConjuntoTDA claves = D.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            int significado = D.recuperar(clave);

            DS.agregar(significado, clave);
            claves.sacar(clave);
        }

        return DS;
    }
}
