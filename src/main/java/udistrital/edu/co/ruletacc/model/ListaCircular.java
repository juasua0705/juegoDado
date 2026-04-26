/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.ruletacc.model;

/**
 * Representa una estructura de datos de Lista Circular Simplemente Enlazada.
 * Esta clase gestiona los nodos de la lista, permitiendo la inserción, eliminación
 * y el control de turnos, diseñada específicamente para el flujo del juego tipo ruleta.
 *
 * @author Andres Ramos - 20242020005
 * @author Sebastián Suárez - 20241020141
 */
public class ListaCircular {
    private Nodo cabeza = null;
    private Nodo cola = null;

    /**
     * Inserta un nuevo nodo con el dato especificado al final de la lista circular.
     * Si la lista está vacía, el nuevo nodo se establece como la cabeza y la cola,
     * y su apuntador siguiente se enlaza a sí mismo para cerrar el círculo.
     *
     * @param dato El valor entero (ID del jugador) que se va a agregar a la lista.
     */
    public void insertar(int dato) {
        Nodo nuevo = new Nodo();
        nuevo.setInfo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cola = nuevo;
        }
    }

    /**
     * Busca y elimina de la lista el nodo que coincida con el valor proporcionado.
     * Ajusta automáticamente los enlaces de la cabeza, la cola y los nodos adyacentes
     * para mantener la integridad de la estructura circular.
     *
     * @param valor El valor entero (ID del jugador) que se desea eliminar.
     * @return true si el nodo fue encontrado y eliminado exitosamente; false si la lista está vacía o el valor no existe.
     */
    public boolean eliminar(int valor) {
        if (cabeza == null) {
            return false; // Lista vacía
        }

        Nodo actual = cabeza;
        Nodo anterior = cola;
        do {
            if (valor == actual.info) {
                if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    cola.siguiente = cabeza;
                } else if (actual == cola) {
                    cola = anterior;
                    cola.siguiente = cabeza;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                // Si la lista queda vacía tras la eliminación
                if (cabeza == cola && cabeza.info == valor) {
                    cabeza = null;
                    cola = null;
                }
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != cabeza);

        return false; // No encontrado
    }

    /**
     * Recorre la lista circular y concatena la información de todos los nodos en una cadena de texto.
     *
     * @return Un String con la secuencia de elementos separados por " -> ", o un mensaje de advertencia si la lista está vacía.
     */
    public String mostrar() {
        String mensaje = "";
        if (cabeza == null) {
            mensaje = "No hay datos en la lista";
            return mensaje;
        }
        Nodo actual = cabeza;
        do {
            mensaje += actual.getInfo() + " -> ";
            actual = actual.siguiente;
        } while (actual != cabeza);
        return mensaje;
    }
    
    /**
     * Obtiene el identificador del jugador que tiene el turno actual (el nodo en la cabeza).
     *
     * @return El valor entero correspondiente a la información del nodo actual, o -1 si la lista no contiene jugadores.
     */
    public int obtenerTurnoActual() {
        if (cabeza != null) {
            // Asumiendo que getInfo() devuelve un int o un String convertible. 
            // Si devuelve un String, cámbialo a: return Integer.parseInt(cabeza.getInfo());
            return (int) cabeza.getInfo(); 
        }
        return -1; // Retorno de seguridad por si la lista está vacía
    }

    /**
     * Desplaza la cabeza de la lista al siguiente nodo.
     * Este método simula el giro de la ruleta, transfiriendo el turno al jugador adyacente.
     */
    public void avanzarTurno() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente; 
        }
    }
    
    /**
     * Calcula y devuelve la cantidad de nodos presentes en la lista circular.
     * Validacion para seguir el ciclo hasta que quede solo un jugador
     *
     * @return El número entero total de elementos en la lista, o 0 si está vacía.
     */
    public int getSize() {
        if (cabeza == null) {
        return 0; 
        }
        Nodo actual = cabeza;
        int size = 0;
        do{
            size++;
            actual = actual.siguiente;
        }while (actual != cabeza);
        return size;
    }
}
