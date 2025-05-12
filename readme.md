##Diagrama de flujo

![imagen](https://github.com/user-attachments/assets/122a233f-dc58-464a-a9a7-06a4dcc46b37)

##Diagrama de estado

![imagen](https://github.com/user-attachments/assets/d8e07373-5dbe-4833-bb66-03c24b94752f)

##Main Activity

Configuración de la pantalla principal.

![imagen](https://github.com/user-attachments/assets/342efa2b-b479-41e8-a3e8-e51ac45e8ca6)

##Datos  

En este archivo se inicializan variables y se crea la clase EstadoJuego que sirve para gestionar el codigo de manera que no haya fallos.

var secuencia = mutableStateListOf<Int>()
val secuenciaJugador = mutableStateListOf<Int>()

var estadoJuego = mutableStateOf(EstadoJuego.ESPERANDO_INICIO)

class Datos {
    var puntuacion = mutableStateOf(0)

}

enum class EstadoJuego {
    ESPERANDO_INICIO,
    MOSTRANDO_SECUENCIA,
    TURNO_JUGADOR,
}

##UI

Funciones que crean los botones para el juego, el inicio del mismo y la puntuación obtenida.
-Boton de juego


    LaunchedEffect(estadoJuego.value) {
    if (estadoJuego.value== EstadoJuego.MOSTRANDO_SECUENCIA){
        for (colorId in secuencia) {
            delay(1500)
            if(color==Color.Green&&colorId==1){
                colorR.value=Color(23, 147, 0, 255)
                delay(500)
                colorR.value=color
            }
            if(color==Color.Red&&colorId==2){
                colorR.value=Color(162, 0, 0, 255)
                delay(500)
                colorR.value=color
            }
            if(color==Color.Yellow&&colorId==3){
                colorR.value=Color(255, 224, 63, 255)
                delay(500)
                colorR.value=color
            }
            if(color==Color.Blue&&colorId==4){
                colorR.value=Color(46, 236, 255, 255)
                delay(500)
                colorR.value=color
            }
        }
        colorR.value=color
        delay(1000)
        estadoJuego.value= EstadoJuego.TURNO_JUGADOR
    }



    }

##ModelView

Se almacenan funciones que se utilizan en los botones.

- fun sumarPuntuación(): Int = Suma la puntuación y la devuelve para actualizarla.

- fun compararExacto(): Boolean = Compara las dos listas y en caso de que estean igual devuelve true y borra la lista del jugador, en caso de que no lo sean borra tanto la secuencia del jugador y la del juego, esta devuelve false.

- fun compararParcial(): Boolean = Hace lo mismo que comparar exacto solo que 
