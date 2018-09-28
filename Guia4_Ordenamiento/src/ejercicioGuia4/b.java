package ejercicioGuia4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class b {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner f=new Scanner (new File("C:/es.txt"));

		String aux =f.useDelimiter("\\A").next();
		String []a=aux.split("\n");
		for(int i=0; i<=a.length; i++) {
			System.out.println(a[i]);
		}
		

	}

	

}
