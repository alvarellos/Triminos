package Tablero;

import java.io.IOException;


public class Tablero {
	// Esta clase define los objetos de tipo tablero y las operaciones sobre ellos.
	// El tablero es una matriz cuadrada de orden 2
	private int n; //dimension
	private char [][] x; //array bidimensional x
	
	// Definimos los 2 constructores necesarios
	
	public Tablero (int n) {
	// Este constructor se le pasa la dimension n de la matriz cuadrada,
	// creando un array bidimensional de n filas y n columnas, e inicializa los 
	// elementos a cero
		this.n=n;
		x=new char[n][n];
		if (n/2==0){
			for (int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					x[i][j]='0';
				}
			}
		}
/*		else { 
			System.out.println("tiene que ser potencia de 2"); // no funciona
		}*/
	}
	
	public Tablero(char[][] x){
	// Al segundo constructor se le pasa un array bidimensional, e inicializa el miembro
	// dato x con los valores que guardan los elementos de dicho array en una 
	// única operación de asignación
		this.x=x;
		n=x.length;
	}
	
	public String toString(){
		String texto ="\n";
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				texto+="\t"+ x[i][j];
			}
			texto+="\n";
		}
		texto+="\n";
		return texto;
	}
	
}

