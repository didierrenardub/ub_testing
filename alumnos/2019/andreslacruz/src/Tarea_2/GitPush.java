package Tarea_2;

public class GitPush implements Comando {
    @Override
    public String nombre() {
        return "git push";
    }

    @Override
    public String descripción() {
        return "Envía los cambios al repositorio remoto";
    }

    @Override
    public void ejecutar(String par) {
        System.out.println("git push");
    }
}
