/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.ruletacc.view;
import java.util.Scanner;

/**
 * Clase encargada de manejar la interacción con el usuario a través de la consola.
 * Proporciona métodos para mostrar información y leer datos ingresados por teclado,
 * separando así la interfaz de usuario de la lógica del negocio.
 *
 * @author Andres Ramos - 20242020005
 * @author Sebastián Suárez - 20241020141
 */
public class VistaConsola {
    private Scanner sc;
	
    /**
     * Constructor de la clase VistaConsola.
     * Inicializa el objeto Scanner para leer la entrada estándar del sistema (teclado).
     */
    public VistaConsola() {
        sc = new Scanner(System.in);
    }
	
    /**
     * Imprime un mensaje o información en la consola para que el usuario lo vea.
     * @param mensaje El texto o información que se desea mostrar en pantalla.
     * 
     */
    public void mostrarInformacion(String mensaje) {
        System.out.println(mensaje);
    }
	
    /**
     * Muestra un mensaje solicitando información y captura la respuesta ingresada
     * por el usuario a través del teclado.
     * @param mensaje El texto indicativo de lo que el usuario debe ingresar (ej. "Ingrese su nombre:").
     * @return Un String con el texto o valor capturado desde la consola.
     */
    public String leerDato(String mensaje) {
        System.out.println(mensaje);
        String dato = sc.nextLine();
        return dato;
    }
}
