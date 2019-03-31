import javax.swing.JOptionPane;

public class PPT {
	
	private int bot;
	private String botElection;
	private int perdidas=0;
	private int ganadas=0;
	
	public PPT() {
		
	}
	
	public String Random() {
		bot=(int) Math.floor(Math.random()*(3-1+1)+1);
		
		switch(bot)
		{
		case 1: botElection="piedra";
		break;
		case 2: botElection="papel";
		break;
		case 3: botElection="tijera";
		break;
		}
		return botElection;
	}
	
	public void Jugar() {
		Random();
		System.out.println(botElection);
		String myPlay=JOptionPane.showInputDialog("Ingrese piedra, papel o tijera:");
		
		switch(myPlay)
		{
		case "piedra": 
			if("piedra".equals(botElection))
			{ 
				JOptionPane.showMessageDialog(null,"igual al bot, vuelva a intentarlo");
			}
			else
			{ 
				if("papel".equals(botElection))
				{
					JOptionPane.showMessageDialog(null,"Perdiste el bot tiene "+botElection);
					perdidas++;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Ganaste");
					ganadas++;
				}
				
			}
			
		break;
		case "papel":
			if("papel".equals(botElection))
					{
				      JOptionPane.showMessageDialog(null,"igual al bot, vuelva a intentarlo");
					}
			else
			{
			   if("piedra".equals(botElection))
			  {
				JOptionPane.showMessageDialog(null,"Ganaste");
				ganadas++;
			    }
			else
			{
				JOptionPane.showMessageDialog(null,"Perdiste el bot tiene "+botElection);
				perdidas++;
			}
			}
		break;
		case "tijera": 
			if("tijera".equals(botElection))
			{
				JOptionPane.showMessageDialog(null,"igual al bot, vuelva a intentarlo");
			}
			else
			{
			    if("piedra".equals(botElection))
			  {
				JOptionPane.showMessageDialog(null,"Perdiste el bot tiene "+botElection);
				perdidas++;
			  }
			    else
			  {
				JOptionPane.showMessageDialog(null,"Ganaste");
				ganadas++;
			  }
			}
		break;
		default: JOptionPane.showMessageDialog(null,("Valor incorrecto, ingrese piedra, papel o tijera"));
		Jugar();
		break;
		}
		VolverJugar();
		
	}
	
	public void VolverJugar() {
		String respuesta=JOptionPane.showInputDialog("Desea volver a jugar y/n:");
		
		if(respuesta.equals("y"))
		{
			JOptionPane.showMessageDialog(null,"Perdidas: "+ perdidas + "Ganadas: "+ganadas);
			Jugar();
		}
		else
		{
			System.exit(0);
		}
	}
}
