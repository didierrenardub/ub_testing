package tareaclase1;

import javax.swing.JOptionPane;


public class TareaClase1 {
    
    static int intentos=0;
    
    public void startGame(){
        int numeroRandom=(int)(Math.random()*10);
        while(intentos<2){
            
            int userNumber = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entre 1 y 10"));
            if(userNumber<numeroRandom){
                JOptionPane.showMessageDialog(null, "El numero ingresado es menor al generado");
            }
            if(userNumber>numeroRandom){
                JOptionPane.showMessageDialog(null,"El numero ingresado es mayor al generado");
            }
            if(userNumber==numeroRandom){
                JOptionPane.showMessageDialog(null, "Acertaste el numero!");
                intentos=2;
            }
            intentos++;
        }
        String msj="Juego Terminado!\nQuiere jugar de nuevo? y/n";
        String call = JOptionPane.showInputDialog(msj);
        intentos=0;
        if(call.equals("y")){
            startGame();
        }        
        if(call.equals("n")){
            JOptionPane.showMessageDialog(null, "Saliste del juego");
        }        
    }
    
    public static void main(String[] args) {
        TareaClase1 t = new TareaClase1();
        t.startGame();
        
    }
    

    
}
