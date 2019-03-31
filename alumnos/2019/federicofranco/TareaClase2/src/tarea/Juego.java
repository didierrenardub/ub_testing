package tarea;
import javax.swing.JOptionPane;

public class Juego {
    static int scorep1=0;
    static int scorep2=0;
    public void startRound(){
        Jugador player1 = new Jugador("Jugador 1");
        Jugador player2 = new Jugador("Jugador 2");
        String move1=player1.hacerJugada();
        String move2=player2.hacerJugada();
        String msj="El Jugador "+ player1.getNombre()+" ha elegido: "+move1+" \n"
                + "El Jugador "+player2.getNombre()+" ha elegido: "+move2;
             
        if(move1.equals(move2)){
            JOptionPane.showMessageDialog(null,msj+"\nLos Jugadores han empatado");
            
        }
         
        switch(move1){
            case("papel"):
                if(move2.equals("tijera")){
                    JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player2.getNombre());
                    scorep2++;
                }
                if(move2.equals("piedra")){
                    JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player1.getNombre());
                    scorep1++;
                }
                break;
            case("tijera"):
                if(move2.equals("piedra")){
                    JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player2.getNombre());
                    scorep2++;
                }
                if(move2.equals("papel")){
                    JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player1.getNombre());
                    scorep1++;
                }
                break;
            case("piedra"):
                if(move2.equals("papel")){
                    JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player2.getNombre());
                    scorep2++;
                }
                if(move2.equals("tijera")){
                    JOptionPane.showMessageDialog(null,msj+"\nGana Jugador: "+player1.getNombre());
                    scorep1++;
                }
                break;
        }
        menu();
        
    }
    
    public void menu(){
        JOptionPane.showMessageDialog(null, "Partida Terminada!\n"
                + "El Jugador1 gano: "+scorep1+"\n"
                + "El Jugador2 gano: "+scorep2);
        String msj="Presione:\n"
                + "1-Volver a Jugar\n"                                
                +"2-Salir";
        String choice=JOptionPane.showInputDialog(msj);
        switch(choice){
            case("1"):startRound();            
            case("2"):
                System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        
        Juego juego = new Juego();
        juego.startRound();
        
    }
    
}
