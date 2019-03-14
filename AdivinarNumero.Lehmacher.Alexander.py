
#TESTING - Tarea Obligatoria I: Adivinar numero
#ALexander Lehmacher

#########################################################################
#########################################################################

import random

#########################################################################
#########################################################################

#Variables utilizadas

azar = random.randrange(1, 10) 				#Generador del numero aleatorio
numeroIntroducido = 0 							#Variable que guarda el numero que elige el usuario
eleccion = 0
intentos = 0									#Veces que el usuario intento adivinar
jugados = 0										#Veces que el usuario jugo
ganados = 0										#Veces que el usuario gano
perdidos = 0									#Veces que el usuario perdio


#########################################################################
######################################################################### 

while True:
	try:
		eleccion = int (input ("Bienvenido. \nPara comenzar presione 1. \nPara salir presione otro numero.\n"))
		break
	except:
		print ("Opcion no valida.")
	
while eleccion == 1:

	jugados +=1

	while True:
		try:
			numeroIntroducido = int (input ("\nElija un numero entero entre 1 y 10: "))
			break
		except:
			print ("Opcion no valida.")

	if numeroIntroducido != azar:

		while intentos < 1:
			if numeroIntroducido < azar:
				numeroIntroducido = int (input("\nNo acertó. Su numero es menor al que hay que adivinar. Vuelva a intentarlo.\nElija un numero entero entre 1 y 10: "))
				intentos +=1

		while intentos < 1:		
			if numeroIntroducido > azar:
				numeroIntroducido = int (input("\nNo acertó. Su numero es mayor al que hay que adivinar. Vuelva a intentarlo.\nElija un numero entero entre 1 y 10: "))
				intentos +=1

	if numeroIntroducido == azar:
		print ("\n¡Felicitaciones, ha ganado!")
		ganados +=1

	else:
		print ("\n¡Ha perdido!\nEl numero era ", azar)
		perdidos +=1

	while True:
		try:
			eleccion = int (input ("\n¿Quiere volver a jugar?\n1. Si\n2. No\n"))
			break
		except:
			print ("Opcion no valida.")
			
	if eleccion == 1:
		print ("\nJugados: ", jugados, "\nGanados: ", ganados, "\nPerdidos: ", perdidos)
	else:
		exit ()

	intentos = 0
	azar = random.randrange(1, 10)

exit ()
