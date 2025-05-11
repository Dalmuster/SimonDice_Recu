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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

val modelView = ModelView()
val datos = Datos()

@Composable
fun botonJuego(color:Color) {
    var colorR = remember { mutableStateOf(color) }


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
        Button(
            onClick = {


                if (estadoJuego.value==EstadoJuego.TURNO_JUGADOR){
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
                            modelView.sumarPuntuación()
                            secuencia.add(modelView.numeroRandom())
                            estadoJuego.value = EstadoJuego.MOSTRANDO_SECUENCIA
                            Log.d("hola","secuencia: ${secuencia.joinToString(", ")}")
                        } else {

                            estadoJuego.value= EstadoJuego.ESPERANDO_INICIO
                            Log.d("hola","secuencia: ${secuencia.joinToString(", ")}")
                        }
                    }
                }else {

                    estadoJuego.value= EstadoJuego.ESPERANDO_INICIO
                    Log.d("hola","secuencia: ${secuencia.joinToString(", ")}")
                }
            }
            },
            modifier = Modifier
                .size(200.dp)
                .padding(20.dp),
            shape = CircleShape,

            colors = ButtonDefaults.buttonColors(
                containerColor = colorR.value
            )
        ) {
        }
    }

@Composable
fun botonStart() {
    Button(
        onClick = {
            Log.d("hola"," ${estadoJuego.value}")
            if(estadoJuego.value== EstadoJuego.ESPERANDO_INICIO){
            secuencia.add(modelView.numeroRandom())
            Log.d("hola"," ${secuencia.joinToString(", ")}")
            Log.d("hola"," ${secuenciaJugador.joinToString(", ")}")
            estadoJuego.value = EstadoJuego.MOSTRANDO_SECUENCIA
                Log.d("hola"," ${estadoJuego.value}")
            }
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