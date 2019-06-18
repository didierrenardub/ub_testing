play = "si"
cont = 0
acierto = 0

while play == "si":
    
    
    from random import randint
    n = (randint(1, 10))
    print (n)
    guess1 = int(input("Pruebe un numero: "))
    
    

    if guess1 == n:
        print("Adivinaste el numero")
        acierto = acierto + 1
        if cont > 0:
            print ("Acertaste " ,acierto, " de " ,cont, " veces")
       
        play = input("Si desea jugar otra vez escriba si o no: ")
        cont = cont + 1
    else:
        if guess1 > n:
            print("El n ingresado es mayor")
            guess2 = int(input("Pruebe otra vez: "))
        if guess1 < n:
            print("El n ingresado es menor")
            guess2 = int(input("Pruebe otra vez: "))

        if guess2 == n:
            acierto = acierto + 1
            cont = cont + 1
            print("Ahora si divinaste el numero")
            if cont > 0:
                print ("Acertaste " ,acierto, " de " ,cont, " veces")
            
           
            play = input("Si desea jugar otra vez escriba si o no: ")
            
            
        else:
            print("Numero incorrecto!")
            play = input("Si desea jugar otra vez escriba si o no: ")
            cont = cont + 1
            
          
    
