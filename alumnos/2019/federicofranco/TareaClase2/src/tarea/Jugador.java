package tarea;





public class Jugador {
    private String nombre;
    private String jugada;
    private String [] movidas = new String [3];  
    
    public Jugador(String nombre) {
        this.nombre = nombre;        
    }

    public String hacerJugada(){  
        movidas[0]="piedra";
        movidas[1]="papel";
        movidas[2]="tijera";
        int numero=(int)(Math.random()*3);
        return movidas[numero];
    }    
    public String getNombre() {
        return nombre;
    }

    public String getJugada() {
        return jugada;
    }

    private void setJugada(String jugada) {
        this.jugada = jugada;
    }
    
    
    
}
