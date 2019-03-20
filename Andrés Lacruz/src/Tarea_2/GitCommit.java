package Tarea_2;

public class GitCommit implements Comando {
    @Override
    public String nombre() {
        return "git commit";
    }

    @Override
    public String descripción() {
        return "Comete los cambios hechos";
    }

    @Override
    public void ejecutar(String par) {
        System.out.println("par");
    }
}
