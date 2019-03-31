package Juego;
import java.util.Random;


import javax.swing.JOptionPane;

public class Numero {
	private double aciertos;
	private double incorrectos;
	private boolean continuar = true;
	private int partidasJugadas = 0;


	public Numero() {
	while (continuar){
		partidasJugadas += 1;
	int rand = new Random().nextInt(10)+1;
	String h = "Perdiste... el numero era " + Integer.toString(rand) ;

	for (int i=1; i<3; i++) {
		String a = JOptionPane.showInputDialog("Intento n#" + i + " (resultado = " + rand + ")");
		if (checkear(a))
		if (a.equals(Integer.toString(rand))) {
			h = "Ganaste!";
			aciertos += 1;
			break;
			}
		else {
			String b = "fallaste";
			if (Integer.parseInt(a)<rand) JOptionPane.showMessageDialog(null, b + ", el numero es mayor");
			else JOptionPane.showMessageDialog(null, b + ", el numero es menor");
			incorrectos += 1;
			}
		else h = "No ingresaste un caracter valido"; partidasJugadas -=1; break;
		}
	int d = JOptionPane.showConfirmDialog(null, h +"\n Juego terminado. Otra vez?", null,JOptionPane.YES_NO_OPTION);
	if (JOptionPane.OK_OPTION != d) continuar = false;

}
	double porcentajeAciertos = (aciertos/(aciertos + incorrectos))*100;
	double porcentajeIncorrectos = 100 - porcentajeAciertos;
	JOptionPane.showMessageDialog(null, "Resultados: \n   Partidas jugadas: " + partidasJugadas + "\n   Aciertos: " + Math.round(aciertos) + " (" + Math.round(porcentajeAciertos) + "%) \n Incorrectos: " + Math.round(incorrectos) + " (" + Math.round(porcentajeIncorrectos) + "%) \n" );
}
	
	public boolean checkear(String a){ 
		try {
			Integer.parseInt(a);
			return true;
		} catch (Exception e){
			return false;
		}
	}

}




	




