package Tarea_2;

public class GitBranch implements Comando {
    @Override
    public String nombre() {
        return "git branch";
    }

    @Override
    public String descripción() {
        return "Enumera las ramas";
    }

    @Override
    public void ejecutar(String par) {
        System.out.println("git branch");
    }
}
