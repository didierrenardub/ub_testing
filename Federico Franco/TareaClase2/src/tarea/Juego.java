package tarea;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Juego {
   
    public void startRound(Jugador player1,Jugador player2){
        
        String move1=player1.hacerJugada();
        String move2=player2.hacerJugada();
        String msj="El Jugador "+ player1.getNombre()+" ha elegido: "+move1+" \n"
                + "El Jugador "+player2.getNombre()+" ha elegido: "+move2;
             
        if(move1.equals(move2)){
            JOptionPane.showMessageDialog(null,msj+"\nLos Jugadores han empatado");
            
        }
         
        switch(move1){
            case("papel"):
                if(move2.equals("tijera"))JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player2.getNombre());
                if(move2.equals("piedra"))JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player1.getNombre());
                break;
            case("tijera"):
                if(move2.equals("piedra"))JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player2.getNombre());
                if(move2.equals("papel"))JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player1.getNombre());
                break;
            case("piedra"):
                if(move2.equals("papel"))JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player2.getNombre());
                if(move2.equals("tijera"))JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player1.getNombre());
                break;
        }
        menu();
        
    }
    
    public void menu(){
        String msj="Presione:\n"
                + "1-Volver a Jugar\n"                
                + "2-Salir";
        String choice=JOptionPane.showInputDialog(msj);
        switch(choice){
            case("1"):
                Jugador jugador = new Jugador(JOptionPane.showInputDialog("Ingrese el nombre del pirimer Jugador"));
                Jugador jugador2 = new Jugador(JOptionPane.showInputDialog("Ingrese el nombre del segundo Jugador"));
                startRound(jugador, jugador2);
                break;
            case("2"):
                System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        Jugador jugador = new Jugador("bot");
        Jugador jugador2 = new Jugador("bot2");
        Juego juego = new Juego();
        juego.startRound(jugador, jugador2);
        
    }
    
}
