package Triminos;
import java.io.IOException;
import Tablero.Tablero;
import InOut.InOut;
import Caracter.Caracter;
import DyV.DyV;


public class Triminos {

	/**
	 * Esta clase contiene el método main del programa
	 * @throws IOException 
	 */
	public static void main(String[] args){
		// Método main del programa
		
		//Tablero prueba1 = new Tablero(null); // dimension 8 (todos elementos =0)
		Caracter simbolo = new Caracter(); // inicio los simbolos
		char p = simbolo.siguiente();
		//char n = simbolo.siguiente();
		//int a = 1,b = 1,c = 1,d=1;
		//int e=4;
		//char [][] a1={{'a','b','c','d'},{'d','e','f','k'},{'g','h','i','m'},{'a','b','c','j'}};
		//char [][] a1={{p,n},{p,p}};
		
		Tablero prueba2 = new Tablero(2);

		char[][] copia=new char[8][8];
		
		
	//	prueba2=DyV.metodo_directo(0,0);
		//System.out.println(prueba2);
		
	//	System.out.println(prueba2);
		
		prueba2=DyV.descomponer(0, 0, copia, 4);
		System.out.println(prueba2);
		// System.out.println(prueba1);  // esto deberia ir en InOut;
	}

}

