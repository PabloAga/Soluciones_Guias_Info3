package Parcial2;

public class Split {

	public static void main(String[] args) {
		String palabra="hola    como    estas yo                    bien"
				+ "";
		String x=" ";
		int tam = 0;
		int pos = 0;
		
	/*	for(int i=palabra.length()-1;i>=0;i--) {
			
			if(x.charAt(0)!=palabra.charAt(i)) {
				 tam++;
				 pos=i;
				 System.out.println(pos);
			 }
			 else
				 i=0;
			}
			char vec[]=new char[tam];
					
			for(int i=0;i<tam;i++) 
				vec[i]=palabra.charAt(i+pos);	
					
			String.valueOf(vec);
			System.out.println(vec);*/
		
		
		
		//la primera
		for(int i=0;i<palabra.length();i++) {
			 if(x.charAt(0)!=palabra.charAt(i))
				 tam++;
			 else
				 i=palabra.length();
	            }
		System.out.println(tam);
		char vec[]=new char[tam];
		
		for(int i=0;i<tam;i++) 
			vec[i]=palabra.charAt(i);
		
		String.valueOf(vec);
		System.out.println(vec);
		
	}
}
