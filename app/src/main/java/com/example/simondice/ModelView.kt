package com.example.simondice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.random.Random

class ModelView {
    var puntuacion by mutableStateOf(0)

    fun sumarPuntuación(): Int {
        datos.puntuacion.value +=1
        return puntuacion
    }

    fun compararExacto(): Boolean {
        if (secuenciaJugador.size != secuencia.size) return false

        for (i in secuencia.indices) {
            if (secuencia[i] != secuenciaJugador[i]) {
                secuencia.clear()
                secuenciaJugador.clear()
                datos.puntuacion.value = 0
                return false
            }
        }
        secuenciaJugador.clear()
        return true
    }

    fun compararParcial(): Boolean {
        val maximo = minOf(secuencia.size, secuenciaJugador.size)

        for (i in 0 until maximo) {
            if (secuencia[i] != secuenciaJugador[i]) {
                secuencia.clear()
                secuenciaJugador.clear()
                datos.puntuacion.value = 0
                return false
            }
        }
        return true
    }

    fun numeroRandom (): Int {
        val numero = Random.nextInt(1, 5)
        return numero
    }
}