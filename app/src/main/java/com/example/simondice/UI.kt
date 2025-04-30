package com.example.simondice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun botonJuego(color:Color) {
        Button(
            onClick = { },
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
