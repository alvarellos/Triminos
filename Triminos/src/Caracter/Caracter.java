package Caracter;

public class Caracter {

		private int indice;
		private int i;
		private static final String cadena =new
		String("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		public Caracter(){
			indice=61;
			i=cadena.length();
		}
		
		public char siguiente(){
			char c;
			c=cadena.charAt(indice);
			indice++;
			if (indice==i){
				indice=0;
			}
			return c;
		}
}
