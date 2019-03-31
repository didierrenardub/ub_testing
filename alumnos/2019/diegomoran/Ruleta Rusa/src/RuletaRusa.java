import javax.swing.JOptionPane;

public class RuletaRusa {

	private int cartuchos;
	private int shoot;
	int perdidasabandono=0;
	int ganadas=0;
	int perdidasshoot=0;
	
	public RuletaRusa() {
		
	}
	
	public int CantCartuchos() {
		this.cartuchos=Integer.parseInt(JOptionPane.showInputDialog("En que dificultad desea jugar:"+"\n"+ 
	                                                                  "1- FACIL"+"\n"+
				                                                      "2-MEDIO"+"\n"+
	                                                                  "3-DIFICIL"));
		switch(cartuchos)
		{
		case 1: cartuchos=6;
		break;
		case 2: cartuchos=8;
		break;
		case 3: cartuchos=10;
		break;
		default: System.out.println("Valor incorrecto");
		CantCartuchos();
		break;
		}
		return cartuchos;
		
	}
	
	public boolean JalarGatillo() {
		String jalar=JOptionPane.showInputDialog("Desea jalar el gatillo? y/n");
		boolean onoff;
		
		if(jalar.equals("y"))
		{
			 onoff=true;
		}
		else
		{
			onoff=false;
		}
		return onoff;
	}
	
	public void Jugar() {
		
		CantCartuchos();
		shoot=(int) Math.floor(Math.random()*(cartuchos-1+1)+1);
		System.out.println(shoot);
		
		for(int i=0;i<cartuchos;i++)
		{
			if(JalarGatillo())
			{
				if(shoot==i+1)
				{
					JOptionPane.showMessageDialog(null,"Perdiste");
					perdidasshoot++;
					break;
				}
			}
			else
				{
					if(shoot!= i+2)
					{
						JOptionPane.showMessageDialog(null,"Perdiste");
						perdidasabandono++;
						break;
					}
					if(shoot== i+2)
					{
						JOptionPane.showMessageDialog(null,"Ganaste");
						ganadas++;
						break;
					}
				}
			}
		String backplay=JOptionPane.showInputDialog("Desea volver a jugar? y/n");
		if(backplay.equals("y"))
		{
			JOptionPane.showMessageDialog(null,"Perdidas por abandono: "+perdidasabandono+" Perdidas por shoot: "+ perdidasshoot+" Ganadas: "+ ganadas);
			Jugar();
		}
		else
		{
			System.exit(0);
		}
		}
	}
	
	

