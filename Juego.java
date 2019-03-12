import java.util.Scanner;

public class Juego {


    private int intentos;
    private int ganadas;
    private int perdidas;


    Scanner s = new Scanner (System.in);


    public Juego (){

        intentos =1;
        ganadas =0;
        perdidas =0;

    }

    public void funcion (int numero){
       int respuesta;
       String aux;
       int acum =0;
       boolean bool = true;

       while (intentos < 3){

           System.out.println("Ingresa un número del 1 al 10:");
           respuesta = s.nextInt();
           s.nextLine();

           if (respuesta < 0 || respuesta >10){
               while (bool){
                   System.out.println("Número incorrecto, ingresa un numero del 1 al 10: ");
                   respuesta = s.nextInt();
                   s.nextLine();
               if (respuesta >0 && respuesta <=10){
                       bool = false;
                    }
               }
           }


           if (respuesta < numero && intentos == 1) {
               System.out.println("El número es mayor.");

           }

           if (respuesta > numero && intentos == 1) {
               System.out.println("El número es menor.");

           }

           if (respuesta == numero){
               System.out.println("Ganaste, el número es: " + numero);
               ganadas++;
               acum++;
               if (ganadas >0|| perdidas > 0 && (acum >1))
                   System.out.println("\t Ganadas: " + ganadas +
                           "\n\t Perdidas: " + perdidas);
               System.out.println("¿Deseas seguir jugando?");
               aux = s.nextLine();
               if (aux.compareToIgnoreCase("si") == 0){
                   intentos =0;
                   numero = (int)(Math.random() * 10) +1;
               } else
                   intentos =3;

           }

           if (intentos == 2 && respuesta != numero){
               System.out.println("Perdiste, el número era: " + numero);
               perdidas++;
               acum++;
               if (ganadas >0 || perdidas > 0 && (acum >1))
                   System.out.println("\t Ganadas: " + ganadas +
                           "\n\t Perdidas: " + perdidas);
               System.out.println("¿Deseas seguir jugando?");
               aux = s.nextLine();
               if (aux.compareToIgnoreCase("si") == 0){
                   intentos =0;
                   numero = (int) (Math.random() * 10) +1;
               }

           } 

           intentos++;

       }


    }





}
