package Tarea_2;

public class GitClone implements Comando {
    @Override
    public String nombre() {
        return "git clone";
    }

    @Override
    public String descripción() {
        return "Crea una copia local de un repositorio remoto";
    }

    @Override
    public void ejecutar(String par) {
        System.out.println("git clone");
    }
}
