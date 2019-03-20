package Tarea_2;

public class GitCheckout implements Comando {
    @Override
    public String nombre() {
        return "git checkout [branch name]";
    }

    @Override
    public String descripción() {
        return "Cambia de rama";
    }

    @Override
    public void ejecutar(String par) {
        System.out.println("git checkout" + "[" + par + "]");
    }
}
