package E_pyCListas;

import java.util.Scanner;



public class e1_Guia5 {

	public static void main(String[] args) throws Exception {
		Scanner entrada= new  Scanner (System.in);  
		colaEnlazadaString cA= new colaEnlazadaString();
		colaEnlazadaString c= new colaEnlazadaString();
		String cita;
		int op;

		System.out.print("Agenda de citas\n\n");

        do {
            System.out.print("1 - Agregar cita\n2 - Eliminar la primera cita\n3 - Lista de citas\n4 - Eliminar todas las citas\n5 - Salir\n\nOption: ");
        	op= entrada.nextInt();

            switch (op) {
                case 1: // Agregar cita

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
                	for(int i=0;!c.estaVacia();i++) {
                		String des=c.desencolar();
                		System.out.printf("(%d) %s\n", i+1,des);
                		cA.encolar(des);
                		}
                	for(int i=0;!cA.estaVacia();i++)  
        				c.encolar(cA.desencolar());
        			
                    break;

                case 4: // Eliminar citas
                    c.vaciar();
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
