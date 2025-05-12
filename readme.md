## Diagrama de flujo

![imagen](https://github.com/user-attachments/assets/122a233f-dc58-464a-a9a7-06a4dcc46b37)

## Diagrama de estado

![image](https://github.com/user-attachments/assets/38dd8ea0-dea6-42dd-9159-a069ae321dd9)

## Lógica

El programa inicia en el estado Esperando Inicio, al pulsar el boton start generara un numero y lo introducira en la lista de secuencia, cambiara al estado Mostrando Secuencia iluminando asi los colores de los botones, cambiara al estado Turno de jugador dejando asi que el jugador pulse los botones y en caso de que hacierte todo generara otro numero para la secuencia y borrara la lista del jugador y despues volvera al estado Mostrar Secuencia, en caso de que no acierte el programa volvera al estado Esperando inicio borrando todas las listas y reseteando la puntuación a cero en el proceso.

## Estados

- Esperando_Inicio: Solo esta activo el boton start.
- Mostrando_Secuencia: No hay nada activo hasta que termine la corrutina.
- Turno_Jugador: Solo estan activos los botones del juego para que puedan usarse por parte del usuario.

## Main Activity

Configuración de la pantalla principal.

![imagen](https://github.com/user-attachments/assets/342efa2b-b479-41e8-a3e8-e51ac45e8ca6)

## Datos  

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

## UI

Funciones que crean los botones para el juego, el inicio del mismo y la puntuación obtenida.

- Boton de juego

Crea un boton del color introducido el cual usa los estados para organizar el flujo del juego:

Este solo tiene utilidad en caso de que el estado del juego sea Turno de jugador en ese caso al pulsarlo se añadira el numero seleccionado dependiendo del color que tenga en caso de que el jugador acierte toda la secuencia pasara al estado Mostrar secuencia lo cual iluminara los botones dependiendo de la secuencia gracias a una corrutina que cambia los colores y luego los devuelve a su estado normal dependiendo del color que tubieran inicialmente.

- Boton start

Crea un boton que en caso de estar en el estado Esperando Inicio (Es el estado inicial) al ser pulsado generara un numero aleatorio entre 1 y 4 haciendo referencia a los botones, y cambiara al estado Mostrar Secuencia iluminando asi los colores.

- Puntuacion

Crea una puntuación con un estilo básico.

## ModelView

Se almacenan funciones que se utilizan en los botones.

- fun sumarPuntuación(): Int = Suma la puntuación y la devuelve para actualizarla.

- fun compararExacto(): Boolean = Compara las dos listas y en caso de que estean igual devuelve true y borra la lista del jugador, en caso de que no lo sean borra tanto la secuencia del jugador y la del juego, esta devuelve false.

- fun compararParcial(): Boolean = Hace lo mismo que comparar exacto solo que solo toma en cuenta hasta la longitud maxima introducida por el jugador.

- fun numeroRandom(): Int = Genera un numero aleatorio y lo devulve.
