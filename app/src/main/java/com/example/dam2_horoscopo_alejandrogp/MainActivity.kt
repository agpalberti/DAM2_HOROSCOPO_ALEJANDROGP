package com.example.dam2_horoscopo_alejandrogp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dam2_horoscopo_alejandrogp.ui.theme.DAM2_HOROSCOPO_ALEJANDROGPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DAM2_HOROSCOPO_ALEJANDROGPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Horoscopo()
                }
            }
        }
    }
}



@Composable
fun SuerteHoróscopo(){

    Text(
        text = "\n" +
                "Amor: ${randomStatus()}\n" +
                "Dinero: ${randomStatus()}\n" +
                "Salud: ${randomStatus()}\n" +
                "Trabajo: ${randomStatus()}"
    )
}

@Composable
fun Title(){

    Text(text = "Horóscopo del día", fontWeight = FontWeight(500), fontSize = 30.sp)

}



@Preview(showBackground = true)
@Composable
fun Horoscopo() {
    DAM2_HOROSCOPO_ALEJANDROGPTheme {

        var color by remember { mutableStateOf(Color.White) }


        Surface(
            Modifier
                .fillMaxSize(), color = color
        ) {



            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
            ) {

                Title()

            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                SuerteHoróscopo()
                Spacer(modifier = Modifier.size(10.dp))
                LuckToday()

            }

            Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {

                BotonColor {
                    color = setOf(
                        Color.White,
                        Color.Blue,
                        Color.Cyan,
                        Color.Gray,
                        Color.DarkGray,
                        Color.Green,
                        Color.LightGray,
                        Color.Magenta,
                        Color.Red,
                        Color.Yellow
                    ).random()
                }


            }
        }

    }


}

fun randomStatus(): String = listOf("Mal", "Regular", "Buena", "Muy buena").random()

@Composable
fun BotonColor(onClick: () -> Unit) {
    var contador by remember { mutableStateOf(0) }
    var text by remember { mutableStateOf("Clickeame!") }

    MaterialTheme {
        Button(onClick = onClick) {
            Text(text)
        }
    }
}