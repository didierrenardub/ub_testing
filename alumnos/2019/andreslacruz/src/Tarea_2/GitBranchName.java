package Tarea_2;

public class GitBranchName implements Comando {
    @Override
    public String nombre() {
        return "git branch [branch name]";
    }

    @Override
    public String descripción() {
        return "Crea una rama nueva";
    }

    @Override
    public void ejecutar(String par) {
        System.out.println("git branch" + "[" + par + "]");
    }
}
