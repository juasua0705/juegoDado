/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.ruletacc.controller;
import udistrital.edu.co.ruletacc.model.ListaCircular;
import udistrital.edu.co.ruletacc.view.VistaConsola;

import java.util.Random;

/**
 * Controlador principal del juego de ruleta.
 * Se encarga de coordinar la lógica del juego, manejar los turnos mediante la 
 * Lista Circular y comunicarse con la vista para interactuar con el usuario.
 *
 * @author Andres Ramos - 20242020005
 * @author Sebastián Suárez - 20241020141
 */
public class Controller {
    VistaConsola vista = new VistaConsola();
    Random random = new Random();
    
    /**
     * Genera un número aleatorio simulando el lanzamiento de un dado de 6 caras.
     * @return Un número entero aleatorio entre 1 y 6 (ambos inclusivos).
     */
    public int generarNum() {
        int min = 1;
        int max = 6;
        // Corrección: La fórmula matemática correcta para un rango inclusivo es (max - min) + 1
        int dado = random.nextInt((max - min) + 1) + min; 
        return dado;
    }
    
    /**
     * Evalúa si un número dado es matemáticamente par.
     * @param numero El número entero a evaluar.
     * @return true si el número es par, false si es impar.
     */
    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }
    
    /**
     * Detiene la ejecución del hilo principal por un tiempo determinado
     * para generar un efecto de suspenso en la consola.
     * @param milisegundos El tiempo en milisegundos que durará la pausa.
     */
    public void pausar(int milisegundos) {
        try {
            Thread.sleep(milisegundos); // Pausa el programa
        } catch (InterruptedException e) {
            System.out.println("Error en la pausa");
        }
    }
    
    /**
     * Método principal que arranca y controla el flujo del juego.
     * Solicita la cantidad de jugadores, inicializa la lista circular y 
     * gestiona los turnos en bucle hasta que solo quede un jugador.
     */
    public void run() {
        vista.mostrarInformacion("Bienvenido al juego tipo ruleta");
        int jugadores = 0;
        do {
            jugadores = Integer.parseInt(vista.leerDato("Por favor ingrese el numero de jugadores"));
        } while (jugadores == 0);

        ListaCircular lista = new ListaCircular();
        for (int i = 1; i <= jugadores; i++) {
            lista.insertar(i);
        }

        // Dejamos que la lista controle los turnos iterando sobre sí misma.
        do {
            vista.mostrarInformacion(lista.mostrar());
            
            // 1. Obtenemos el ID del jugador al que le toca el turno (el actual)
            int idActual = lista.obtenerTurnoActual(); 
            
            int num = generarNum();
            vista.mostrarInformacion("Es el turno del jugador: " + idActual);
            pausar(1500); // Pausa para darle suspenso
            vista.mostrarInformacion("Saco el numero: " + num);
            pausar(2000);

            // Simplificación lógica: "!esPar()" se lee como "Si NO es par"
            if (!esPar(num)) { 
                lista.eliminar(idActual);
                vista.mostrarInformacion("El jugador " + idActual + " fue eliminado :c");
                pausar(2000);
            } else {
                // Si el jugador se salva (es par), simplemente giramos la ruleta al siguiente
                lista.avanzarTurno(); 
            }
            
        } while (lista.getSize() > 1); 
        
        // Al salir del while, la ruleta se detiene porque solo queda 1 jugador
        vista.mostrarInformacion("¡El ganador es el jugador " + lista.obtenerTurnoActual() + "!");
    }
}
