
package javaapplication28;

import java.util.Random;
import java.util.Scanner;

public class JavaApplication28 {

    public static void main(String[] args) {
        // TODO code application logic here
        		//numero random
		Random rand = new Random();
		int numeroRandomm = rand.nextInt(10);
		numeroRandomm += 1;
                
                System.out.println(numeroRandomm);
                
                Scanner reader = new Scanner(System.in);
                Scanner teclado = new Scanner(System.in);
		//arranca el juego
                int i=0;
                int contador1=0;
                int contador2=0;
                while (i==0){
                    for ( int intentos = 0; intentos <2; intentos ++ ) {
                                System.out.println("Ingrese un numero del 1 al 10");
				int numeroJugador = reader.nextInt();
				if  (numeroJugador == numeroRandomm) {
                                    intentos =10;
                                    contador1++;
                                } if (numeroJugador < numeroRandomm) {
                                    System.out.println("El numero es Mayor");
                                    contador2++;
                                }if (numeroJugador > numeroRandomm) {
                                    System.out.println("El numero es Menor");
                                    contador2++;
                                }
			}	
                System.out.println("Si quieres seguir jugando presione y");
                String j = teclado.nextLine();
                if ("y".equals(j) || "Y".equals(j)){
                    i = 0;
                } else {
                    i=1;
                }
                    System.out.println("acertaste "+ contador1 +" veces");
                    System.out.println("no acertaste "+ contador2 +" veces");
                }
    }
}
