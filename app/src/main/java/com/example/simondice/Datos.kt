package com.example.simondice

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

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