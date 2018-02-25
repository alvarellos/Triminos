package DyV;

import Tablero.Tablero;
import Caracter.Caracter;


public class DyV {
	// Esta clase implementa la funcionalidad del esquema de divide y vencerás
	// Tiene un método llamado triminosDyV
	// Métodos : indivisible, metodo_directo, descomponer, combinar;

// ------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------
	

	public static boolean indivisible(int dimension){
	// Las dimensiones son 2,4,8 (potencias de 2)
	// El método comprueba que estamos en el caso base. Dimension 2 (tablero de 2x2)
		return (dimension==2);
	}
	
// ------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------

	
	public static char[][] combinar(char centro[][],char dividido[][], char dividido2[][], char dividido3[][], char dividido4[][], int d, char n){
		// Combina los subtableros. ESTE MÉTODO NO FUNCIONA.

		Caracter simbolo=new Caracter();
		char p=simbolo.siguiente();
	  
		//primer cuadrante
		for (int i=0; i<d/2; i++){
			for(int j=0; j<d/2; j++){
				centro[i][j]=dividido[i][j];
			}
		}

		p=simbolo.siguiente();
	    //segudno cuadrante
	    for (int s=0; s<d/2; s++){
			for(int m=d/2; m>=d-1; m++){
				centro[s][m]=dividido2[s][m+d/2];
					}
				}
	    p=simbolo.siguiente();    

		//tercer cuadrante
	    for (int i=d/2; i>=d-1; i++){
			for(int j=0; j<d/2; j++){
			centro[i][j]=dividido3[i+d/2][j];

			}
		}
	    		
	    p=simbolo.siguiente();
	    
	    //cuarto cuadrante
		for (int i=d/2; i<d-1; i++){
			for(int j=d/2; j>=d-1; j++){
			centro[i][j]=dividido4[i+d/2][j+d/2];
			}
		}
	    
	    	n=simbolo.siguiente();
	    	

		return centro;
	}
	
// ------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------

	public static char[][] metodo_directo(int x, int y,char cuadrado[][], char n, int d){		

		Caracter simbolo =new Caracter();
		char p = simbolo.siguiente();

		for (int i=0; i<d; i++){
			for(int j=0; j<d; j++){
				cuadrado[i][j]=n;
			}
		}
		
			if (x==0 && y==0){		// 1 cuadrante		
				cuadrado[0][0]=p;
			}
			else if (x==0 && y==1){  // 2 cuadrante
				cuadrado[0][1]=p;
			}
			else if (x==1 && y==0){  // 3 cuadrante
				cuadrado[1][0]=p;
			}
			else if (x==1 && y==1){  // 4 cuadrante
				cuadrado[1][1]=p;
			}
			else {
				System.out.println("no estamos en un caso trivial");
			}
			
			n=simbolo.siguiente();

		
		return cuadrado;
}



// ------------------------------------------------------------------------------------------------------------

	public static Tablero triminosDyV(int x, int y, char copia[][], int d){
		char[][] centro = new char[d][d];
		Tablero resultado=new Tablero(centro);
		resultado=descomponer(x,y,copia,d);
	
// esta parte esta sin terminar
		return resultado;
	}
	// ------------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------
	
	public static Tablero descomponer (int x, int y, char copia[][], int d){

		Caracter simbolo = new Caracter();
		int coordx=x;
		int coordy=y;
		
		char p = simbolo.siguiente();
		char n = simbolo.siguiente();

		char[][] centro = new char[d][d];
		Tablero solucion = new Tablero(centro);
		
		char[][] centro1 = new char[d][d];
		char[][] centro2 = new char[d][d];
		char[][] centro3 = new char[d][d];
		char[][] centro4 = new char[d][d];

		Tablero dividido1 = new Tablero(centro1);
		Tablero dividido2 = new Tablero(centro2);			
		Tablero dividido3 = new Tablero(centro3);
		Tablero dividido4 = new Tablero(centro4);

		if (indivisible(d)){

			centro=metodo_directo(x,y,centro,n,d);


		}
		else {

			if (x<=d/2-1 && y<=d/2-1){

				//Caracter especial esta en el primer cuadrante. Dibujo el trimino en el centro
				//-----------------------------------------------------------------
				
				centro[d/2-1][d/2]=p; // dibujo caracter en el segundo cuadrante
				centro[d/2][d/2-1]=p; // dibujo caracter en el tercer cuadrante
				centro[d/2][d/2]=p; // dibujo el caracter en el cuarto cuadrante

			   // SE CALCULA LA POSICION EN LOS SUBTABLEROS
				
				int a1=x;
				int b1=y;
			
				int a2=d/2-1;
				int b2=0;			
				
				int a3=0;
				int b3=d/2-1;
				
				int a4=0;
				int b4=0;

				dividido1=descomponer(a1,b1,copia,d/2);
				dividido2=descomponer(a2,b2,copia,d/2);
				dividido3=descomponer(a3,b3,copia,d/2);
				dividido4=descomponer(a4,b4,copia,d/2);
	
			    centro=combinar(centro,centro1, centro2, centro3, centro4, d,n);

			    System.out.println(dividido1);
			    System.out.println(dividido2);
				System.out.println(dividido3);
				System.out.println(dividido4);	

			}
			else if (x<=d/2-1 && y>=d/2){ 
					//Caracter especial esta en el segundo cuadrante. Dibujo el resto
					//----------------------------------------------------------------
				centro[d/2][d/2]=p; //cuarto cuadrante
				centro[d/2-1][d/2-1]=p; // primer cuadrante 
				centro[d/2][d/2-1]=p; // tercer cuadrante
				
				int a1=d/2-1;
				int b1=d/2-1;
			
				int a2=x;
				int b2=y-d/2;		
				
				int a3=0;
				int b3=d/2-1;
				
				int a4=0;
				int b4=0;

				dividido1=descomponer(a1,b1,centro1,d/2);	
				dividido2=descomponer(a2,b2,centro2,d/2);
				dividido3=descomponer(a3,b3,centro3,d/2);
				dividido4=descomponer(a4,b4,centro4,d/2);

				System.out.println(dividido1);
				System.out.println(dividido2);
				System.out.println(dividido3);
				System.out.println(dividido4);	
	
			    centro=combinar(centro,centro1, centro2, centro3, centro4, d,n);
			
			}
			else if (x>=d/2 && y<d/2){ 
				//Caracter especial esta en el tercer cuadrante. Dibujo el resto
				centro[d/2][d/2]=p; // cuarto cuadrante
				centro[d/2-1][d/2-1]=p; // primer cuadrante
				centro[d/2-1][d/2]=p; // segundo cuadrante
				
				int a1=d/2-1;
				int b1=d/2-1;
			
				int a2=d/2-1;
				int b2=0;		
				
				int a3=x-d/2;
				int b3=y;
				
				int a4=0;
				int b4=0;
				
				dividido1=descomponer(a1,b1,centro1,d/2);	
				dividido2=descomponer(a2,b2,centro2,d/2);
				dividido3=descomponer(a3,b3,centro3,d/2);
				dividido4=descomponer(a4,b4,centro4,d/2);

				System.out.println(dividido1);
				System.out.println(dividido2);
				System.out.println(dividido3);
				System.out.println(dividido4);	

			    centro=combinar(centro,centro1, centro2, centro3, centro4, d,n);
			
			}
			else if (x>=d/2 && y>=d/2){
				//Caracter especial esta en el cuarto cuadrante. Dibujo el resto
				centro[d/2-1][d/2-1]=p; //primer cuadrante
				centro[d/2-1][d/2]=p;   //segundo cuadrante
				centro[d/2][d/2-1]=p;   // tercer cuadrante
				
				
				int a1=d/2-1;
				int b1=d/2-1;
			
				int a2=d/2-1;
				int b2=0;		
				
				int a3=0;
				int b3=d/2-1;
				
				int a4=x-d/2;
				int b4=y-d/2;
				
				dividido1=descomponer(a1,b1,centro1,d/2);	
				dividido2=descomponer(a2,b2,centro2,d/2);
				dividido3=descomponer(a3,b3,centro3,d/2);
				dividido4=descomponer(a4,b4,centro4,d/2);

				System.out.println(dividido1);
				System.out.println(dividido2);
				System.out.println(dividido3);
				System.out.println(dividido4);	

			}
			
			else{
				System.out.println("Esta fuera de rango");
			}
		    centro=combinar(centro,centro1, centro2, centro3, centro4, d,n);
		}



   //centro=combinar(centro,centro1, centro2, centro3, centro4, d,n);

		centro[coordx][coordy]='#';


		return solucion;
		
	}
	

	
}

