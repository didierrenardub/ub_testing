var boton = document.getElementById("botona");

boton.onclick= function activarNumero(){

	var a= Math.floor((Math.random()*10)+1);
	document.getElementById('num').innerHTML = a;
}

var botons = document.getElementById("botonb");

botons.onclick=function(){
	location= "https://www.google.com.ar/";
}

var botonss=document.getElementById("botonc");
botonss.onclick=function(){
	history.back();
}