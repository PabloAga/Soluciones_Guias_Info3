package E_Arboles;

import java.util.Scanner;

public class e1_G6_5 {

	public static void main(String[] args) {
		        int n, bandera, elemento, niveles;
		        Scanner entrada = new Scanner(System.in);
		        ArbolBinario arbol = new ArbolBinario();
	
		        NodoBinario nodob = new NodoBinario(0);
		        System.out.println("Cargue 10 numeros enteros entre 0 y 25:\n");
		        for (int i = 0; i < 10; i++) {
		            bandera = 0;
		            do {
		                System.out.println("Ingrese elemento: ");
		                elemento = entrada.nextInt();
		                if (elemento < 0 || elemento > 25) {
		                    System.out.println("\nIngreso invalido\n");
		                } else {
		                    if (i == 0) {
		                        nodob = new NodoBinario(elemento, null, null);
		                        arbol.raiz = nodob;
		                        bandera = 1;
		                    } else {
		                        stree(elemento, arbol.raiz, nodob);
		                        bandera = 1;
		                    }
		                }
		            }
		            while (bandera == 0);
		        }
		        System.out.print("\nArbol ingresado: ");
		        arbol.imprimirEnOrden();
		        System.out.println("\nCantidad de niveles del mismo: " + niveles(arbol.raiz));
		    }

		    public static NodoBinario stree(int x, NodoBinario r, NodoBinario t) {
		        if (t == null) {
		            t = new NodoBinario(x, null, null);
		            if (r == null) {
		                return t;
		            }

		            if (x <= r.dato) {
		                r.izquierdo = t;
		            } else {
		                r.derecho = t;
		            }

		            return t;
		        }

		        if (x <= t.dato) //datos duplicados, a la derecha
		        {
		            stree(x, t, t.izquierdo);
		        } else {
		            stree(x, t, t.derecho);
		        }

		        return t;
		    }

		    public static int niveles(NodoBinario a) {
		        return 1 + Math.max(NodoBinario.altura(a.izquierdo), NodoBinario.altura(a.derecho));
		    }
		}