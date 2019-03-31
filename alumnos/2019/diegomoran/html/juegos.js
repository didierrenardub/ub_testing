var boton= document.getElementById("botona");
var numero=Math.floor((Math.random()*10)+1);
var mostrar=document.getElementById("mostrar");
mostrar.innerHTML=numero;
var incorrectos=0;
var aciertos=0;
var cont=1;

boton.onclick= function Ejecutar(){
	var texto= document.getElementById("ingreso").value;
    
    if(numero!=texto && cont==2)
	{
		incorrectos++;
		document.getElementById("borrar2").style.display="none";
		document.getElementById("ganapierde").innerHTML="Perdiste!!!";
		document.getElementById("in").innerHTML=incorrectos;
		document.getElementById("ac").innerHTML=aciertos;
		document.getElementById("borrar").style.display="block";
	}
	if(numero>texto && cont==1) 
	{
		incorrectos++;
		alert("El numero es mayor");
        cont++;
        document.getElementById("ingreso").value='';
	}
	else
	{
		if(numero<texto && cont==1)
		{   cont++;
			incorrectos++;
		    alert("El numero es menor");
		    document.getElementById("ingreso").value='';
	    }
	}

    
	
	if(numero==texto)
	{
		aciertos++;
		document.getElementById("borrar2").style.display="none";
		document.getElementById("ganapierde").innerHTML="Ganaste!!!";
		document.getElementById("ac").innerHTML=aciertos;
		document.getElementById("in").innerHTML=incorrectos;
		document.getElementById("borrar").style.display="block";
		
	}


}

