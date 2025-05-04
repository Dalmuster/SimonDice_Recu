package com.example.simondice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ModelView {
    var puntuacion by mutableStateOf(0)
        private set

    fun sumarPuntuación(): Int {
        puntuacion++
        return puntuacion
    }
}