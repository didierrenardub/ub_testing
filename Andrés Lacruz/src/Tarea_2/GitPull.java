package Tarea_2;

public class GitPull implements Comando {
    @Override
    public String nombre() {
        return "git pull";
    }

    @Override
    public String descripción() {
        return "Actualiza el repositorio local con el commit más nuevo";
    }

    @Override
    public void ejecutar(String par) {
        System.out.println(par);
    }
}
