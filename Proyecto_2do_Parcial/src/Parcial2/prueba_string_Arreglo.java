package Parcial2;

public class prueba_string_Arreglo {

	public static void main(String[] args) {
		String sCadena = "H-o[-l-a)]}";
		cola_Enlazada_AnyType cola_Signos= new cola_Enlazada_AnyType();
		//colaEnlazadaAnyType cola_Sig= new colaEnlazadaAnyType();
		cola_Enlazada_AnyType cola_Palabra= new cola_Enlazada_AnyType();
	//	colaEnlazadaAnyType cola_Letra= new colaEnlazadaAnyType();
		char signos[]= new char[15];
		char palabra_1[]= new char[15];
	//	char palabra_2[]= new char[15];
		String str_signos, str_palabra1;
		int k=0, b=0,v=0;;
		boolean p=true, s=true,h=true;
		
		for(int i=0;i<sCadena.length(); i++ ) {
		//char sSubCade= sCadena.substring(i,i+1);
		//System.out.println(sCadena.charAt(i));
		int letra =(int) sCadena.charAt(i);
		//System.out.println((char)72);
		//if(letra>=65 && letra<=90)
		//	System.out.println("\n"+(char)letra);
		//else {
		if(letra>=33 && letra<=47 || letra>=58&& letra<=64 || letra>=91 && letra<=96 ||letra>=123 && letra<=126 ) {//detecta caracteres
			signos[k]=(char) letra;
			k++;
			p=true;
			if(!h)//bandera h para avisar que paso por un signo 
			s=false;//bandera s para avisar que paso por un signo y si la proxima es una letra que encole la palabra 
					//anterior y despues guade en la palabra en el arreglo 
		}
		else {
			while(b<2) {
			if(s) {
				if(letra>=97 && letra<=122 || letra>=65 && letra<=90 ) {
					palabra_1[v]=(char) letra;
					v++;
					s=true;
					h=false;
					b+=2;//para salir del while
			}
			}
			else {
				str_palabra1=String.valueOf(palabra_1);
				cola_Palabra.encolar(str_palabra1);
				v=0;//para que la siguien palabra enpieze en la posicion 0 del arreglo
				h=true;
				s=true;
				b++;//pasa una vez mas por el while para guardar la palabra en el arreglo
			}
			}
			b=0;
			if(p) {
			if(letra>=97 && letra<=122 || letra>=65 && letra<=90 ) {
				signos[k]='1';
				k++;
				p=false;
				}
			}
		
		}
		}
		str_palabra1=String.valueOf(palabra_1);// como encola la palabra anterior cada vez que ingresa una palabra nueva , se perdia
		cola_Palabra.encolar(str_palabra1);//la ultima palabra porque no encolaba , de esta forma se soluciono
	//	}
		str_signos=String.valueOf(signos);
		cola_Signos.encolar(str_signos);
		
		
		
		String sign_Split[] =str_signos.split("1");
		
		for(int y=0; y<sign_Split.length;y++) {
			System.out.println(sign_Split[y]);
		}

		
		
		
		while(cola_Palabra.estaVacia()==false) {
			try {
				System.out.print(cola_Palabra.desencolar()+"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		while(cola_Signos.estaVacia()==false) {
			try {
				System.out.print(cola_Signos.desencolar());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
