package E_pilasycolas;

import java.io.StreamCorruptedException;

public class cola_pablo {
 private int size;
 private String[] dato;
 int front, back;
 
 public cola_pablo() {
	 size=0;
	 dato= new String[10];
	 front=0;
	 back=-1;
 }
 public cola_pablo(int t) {
	 size=0;
	 dato= new String[t];
	 front=0;
	 back=-1;
 }
 
 public void encolar(String d) {
	 if(isEmpty())
		 duplicarCola();
	 back= incrementar(back);
	 dato[back]= d;
	 size++;
	 
	 
 }
 
 public String desencolar() throws Exception {
	 if(isEmpty())
		throw new Exception ("La cola esta vacia");
	 size--;
	 String d=dato[front];//devuelve el valor del principio de la cola
	 front= incrementar(front);//consulta si al incrementar no se va al final de la cola, si se va lo incrementa al principio
	 return d;
 }
 
 public String primer_Elemento() throws Exception {
	 if(isEmpty())
		throw new Exception ("La cola esta vacia");
	 return dato[front];
	 
 }
 public void makeEmpty() {
	 front=0;
	 back=-1;
	 size=0;
 }
 
 public boolean isEmpty() {
	 return size==0;
 }
 public int tamaño() {
	 return size;
 }
 
 private void duplicarCola() {//importante
	 String[] new_array;
	 new_array= new String[dato.length*2];
	 
	 for(int i=0; i<size; i++ , front=incrementar(front))//Importante
		 new_array[i]=dato[front];
	 dato=new_array;
	 front=0;
	 back=-1;
	 
	 
 }
 
 private int incrementar(int puntero) {// metodo para colas enlazadas remplaza al back++ y front++, pregunta si  el puntero esta al
	 if(++puntero== dato.length)	   //  finalde la cola si es asi pone el puntero al principio de la cola si no,queda como esta
		 puntero=0;
	 return puntero;
	 }
}
