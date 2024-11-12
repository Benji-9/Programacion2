package com.uade.app.colasprioridad;

import com.uade.api.ColaPrioridadTDA;
import com.uade.api.DiccionarioMultipleTDA;
import com.uade.impl.DiccionarioMultipleTDAImpl;
import com.uade.impl.ColaPrioridadTDAImpl;
import com.uade.util.OperacionDiccionario;

public class TP3EjercicioA {
    public static void main(String[] args) {
        TP3EjercicioA app = new TP3EjercicioA();
        app.execute();
    }

    private void execute() {
        // Inicializamos la ColaPrioridad
        ColaPrioridadTDA cola = new ColaPrioridadTDAImpl();
        cola.inicializarCola();

        // Agregamos elementos con sus prioridades
        cola.acolarPrioridad(1, 5);
        cola.acolarPrioridad(2, 3);
        cola.acolarPrioridad(1, 7);  // Misma clave con otra prioridad
        cola.acolarPrioridad(3, 2);
        cola.acolarPrioridad(2, 1);  // Misma clave con otra prioridad

        // Generamos el Diccionario Múltiple desde la ColaPrioridad
        DiccionarioMultipleTDA diccionario = generarDiccionarioDesdeCola(cola);

        // Mostrar el Diccionario
        OperacionDiccionario.mostrarDiccionario(diccionario);
    }

    public static DiccionarioMultipleTDA generarDiccionarioDesdeCola(ColaPrioridadTDA cola) {
        DiccionarioMultipleTDA diccionario = new DiccionarioMultipleTDAImpl();
        diccionario.inicializarDiccionario();

        ColaPrioridadTDA auxCola = new ColaPrioridadTDAImpl();
        auxCola.inicializarCola();

        // Recorremos la cola de prioridad
        while (!cola.colaVacia()) {
            int valor = cola.primero();
            int prioridad = cola.prioridad();

            // Agregamos el valor y la prioridad al diccionario
            diccionario.agregar(valor, prioridad);

            // Pasamos el elemento a una cola auxiliar para no perder los datos
            auxCola.acolarPrioridad(valor, prioridad);
            cola.desacolar();
        }

        // Restauramos la cola original
        while (!auxCola.colaVacia()) {
            int valor = auxCola.primero();
            int prioridad = auxCola.prioridad();
            cola.acolarPrioridad(valor, prioridad);
            auxCola.desacolar();
        }

        return diccionario;
    }

}