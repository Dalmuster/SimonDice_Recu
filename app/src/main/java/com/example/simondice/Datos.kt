package com.example.simondice

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

var secuencia = mutableStateListOf<Int>()
val secuenciaJugador = mutableStateListOf<Int>()

class Datos {
    var puntuacion = mutableStateOf(0)
    val ronda = mutableStateOf(0)

}