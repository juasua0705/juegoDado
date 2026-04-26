/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.ruletacc.model;

/**
 * Representa la unidad básica (nodo) de una estructura de datos enlazada,
 * en este caso, diseñada para almacenar la información de un jugador en la ruleta.
 * Contiene un dato entero y una referencia al siguiente nodo en la lista.
 *
 * @author Andres Ramos - 20242020005
 * @author Sebastián Suárez - 20241020141
 */
public class Nodo {

    int info;
    Nodo siguiente;
    
    /**
     * Constructor por defecto de la clase Nodo.
     * Inicializa la información en 0 y el apuntador al siguiente nodo como nulo.
     */
    public Nodo() {
        this.info = 0;
        this.siguiente = null;
    }
    
    /**
     * Constructor de la clase Nodo con parámetros iniciales.
     * * @param info El dato entero (ID del jugador) que almacenará el nodo.
     * @param siguiente La referencia al siguiente nodo en la lista enlazada.
     */
    public Nodo(int info, Nodo siguiente) {
        this.info = info;
        this.siguiente = siguiente;
    }

    /**
     * Obtiene la información que está almacenada actualmente en el nodo.
     * * @return Un entero correspondiente al dato contenido en el nodo.
     */
    public int getInfo() {
        return info;
    }
        
    /**
     * Establece o sobrescribe la información almacenada en el nodo.
     * * @param info El nuevo dato entero que se guardará.
     */
    public void setInfo(int info) {
        this.info = info;
    }
        
    /**
     * Obtiene la referencia al nodo que le sigue en la estructura enlazada.
     * * @return El objeto Nodo enlazado, o null si no apunta a ninguno.
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * Establece o modifica el enlace apuntando hacia otro nodo.
     * Es fundamental para conectar la lista circular.
     * * @param siguiente El nuevo objeto Nodo al que apuntará este nodo.
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
        
    /**
     * Devuelve una representación en formato de texto de la información del nodo.
     * * @return Un String estructurado mostrando el dato interno (ej. "Nodo[ info = 5 ]").
     */
    @Override
    public String toString() {
        return "Nodo[ info = " + info +" ]";
    }
    
}
