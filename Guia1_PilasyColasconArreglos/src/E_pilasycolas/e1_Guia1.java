/*Implemente un apuntador de citas usando el concepto de cola circular
implementada mediante el uso de un arreglo.*/
package E_pilasycolas;


import java.util.Scanner;

import javax.swing.JOptionPane;

public class e1_Guia1 {

	public static void main(String[] args) throws Exception {
		Scanner entrada= new  Scanner (System.in);  
		cola_String c= new cola_String();
		int op;
		String cita;

		System.out.print("Agenda de citas\n\n");

        do {
            System.out.print("1 - Agregar cita\n2 - Eliminar la primera cita\n3 - Lista de citas\n4 - Eliminar todas las citas\n5 - Salir\n\nOption: ");
        	op= entrada.nextInt();

            switch (op) {
                case 1: // Agregar cita
                    if (c.estaLlena()) {
                        System.out.println("\nLa Agenda esta llena!\n");
                        break;
                    }

                    System.out.print("\nNueva cita: ");
                    cita = entrada.next();
                    c.encolar(cita);
                    System.out.println();
                    break;

                case 2: // eliminar cita
                    if (c.estaVacia()) {
                        System.out.println("\nLa agenda esta vacia\n");
                    } else {
                        System.out.println(c.salida());
                        c.desencolar();
                        System.out.println("\nSe elimino la cita.\n");
                    }
                    break;

                case 3: // Agenda de citas
                    if (c.estaVacia()) {
                        System.out.println("\nLa agenda esta vacia.\n");
                        break;
                    }

                    c.mostrar_Arreglo();;
                    break;

                case 4: // Eliminar citas
                    c.eliminar_Elementos();;
                    System.out.println("\nSe elimino todos las citas .\n");
                    break;

                case 5: // Salir
                    System.exit(0);

                default:
                    System.out.print("\nOpcion invalida\n\n");
            }
        }
        while (op != 5);
    }
}