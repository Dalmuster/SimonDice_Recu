package com.example.simondice

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

val modelView = ModelView()
val datos = Datos()

@Composable
fun botonJuego(color:Color) {
        Button(
            onClick = {


                if (color==Color.Green){
                    secuenciaJugador.add(1)
                }
                if (color==Color.Red){
                    secuenciaJugador.add(2)
                }
                if (color==Color.Yellow){
                    secuenciaJugador.add(3)
                }
                if (color==Color.Blue){
                    secuenciaJugador.add(4)
                }

                Log.d("hola","Jugador: ${secuenciaJugador.joinToString(", ")}")
                if(modelView.compararParcial()==true){
                    if(secuencia.size==secuenciaJugador.size){
                        if(modelView.compararExacto()){
                            Log.d("hola","puntuacion: ${modelView.puntuacion}")
                            modelView.sumarPuntuación()
                            secuencia.add(modelView.numeroRandom())
                            Log.d("hola","secuencia: ${secuencia.joinToString(", ")}")
                        }
                    }



                }

            },
            modifier = Modifier
                .size(200.dp)
                .padding(20.dp),
            shape = CircleShape,

            colors = ButtonDefaults.buttonColors(
                containerColor = color
            )
        ) {
        }
    }

@Composable
fun botonStart() {
    Button(
        onClick = {
            secuencia.add(modelView.numeroRandom())
            Log.d("hola"," ${secuencia.joinToString(", ")}")
            Log.d("hola"," ${secuenciaJugador.joinToString(", ")}")
        },
        modifier = Modifier
            .size(150.dp)
            .padding(20.dp),
        shape = RectangleShape,

        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        )
    ) {
        Text(
            text = "Start",
            color = Color.Black
        )
    }
}

@Composable
fun Puntuacion() {
    Column {
        Text(
            text = "Puntuación",
            color = Color.Black
        )
        Text(
            text = "${datos.puntuacion.value}",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .border(
                    width = 2.dp,
                    color = Color.Black
                )
                .padding(horizontal = 20.dp)

        )
    }
}