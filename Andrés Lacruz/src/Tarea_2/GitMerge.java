package Tarea_2;

public class GitMerge implements Comando {
    @Override
    public String nombre() {
        return "git merge [branch name]";
    }

    @Override
    public String descripción() {
        return "Incorpora una rama a la rama activa";
    }

    @Override
    public void ejecutar(String par) {
        System.out.println("git merge" + "[" + par + "]");
    }
}
