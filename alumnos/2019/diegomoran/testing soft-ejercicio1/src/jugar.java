import javax.swing.JOptionPane;

public class jugar {

	private int numero;
	private int numjugado;
	private int numjugado2;
	private int acertados=0;
	private int incorrectos=0;
	
	public jugar() {
	
		
	}
	
	public void jugarIntentos()
	{
		String b="y";
		String a="y";
        int vueltas=0;	
		
		while(b.equals(a))
		{
		
		this.numero= (int)(Math.random()* 10);
		System.out.println(numero);
		this.numjugado=Integer.parseInt(JOptionPane.showInputDialog("Ingresar numero del 1 al 10: "));
		
		
		while(numjugado>10)
		{
			JOptionPane.showMessageDialog(null,"Numero fuera del rango, vuelva a intentarlo");
			this.numjugado=Integer.parseInt(JOptionPane.showInputDialog("Ingresar numero del 1 al 10: "));
		}
		
		if(numero>numjugado)
		{
			incorrectos++;
			JOptionPane.showMessageDialog(null,"Numero incorrecto,el numero es mayor");
			this.numjugado2=Integer.parseInt(JOptionPane.showInputDialog("Ingresar numero del 1 al 10 : "));
			
			while(numjugado2>10)
			{
				JOptionPane.showMessageDialog(null,"Numero fuera del rango, vuelva a intentarlo");
				this.numjugado2=Integer.parseInt(JOptionPane.showInputDialog("Ingresar numero del 1 al 10: "));
			}
			
			if(numero!=numjugado2)
			{
				incorrectos++;
			
			}
		}
		if(numero<numjugado)
		{
			incorrectos++;
			JOptionPane.showMessageDialog(null,"Numero incorrecto,el numero es menor");
			this.numjugado2=Integer.parseInt(JOptionPane.showInputDialog("Ingresar numero 2: "));
			if(numero!=numjugado2)
			{
				incorrectos++;
				
			}
		}
		if(numero==numjugado || numero==numjugado2)
		{
			acertados++;
			JOptionPane.showMessageDialog(null,"Adivinaste!!!");
			
		}
		
		a=JOptionPane.showInputDialog("¿Desea jugar de nuevo:? y/n");
		if(vueltas>0)
		{
			JOptionPane.showMessageDialog(null, "Acertados : "+ acertados + "Incorrectos : "+incorrectos);
		}
		
		vueltas++;
	}
	
}
}