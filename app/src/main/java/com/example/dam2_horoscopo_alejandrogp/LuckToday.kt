package com.example.dam2_horoscopo_alejandrogp

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dam2_horoscopo_alejandrogp.ui.theme.DAM2_HOROSCOPO_ALEJANDROGPTheme
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.*
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun LuckToday() {
    DAM2_HOROSCOPO_ALEJANDROGPTheme() {



                var input by remember {
                    mutableStateOf("")
                }

                Text(text = "Tu suerte del día:\n" )

                TextField(value = input, onValueChange = {input = it}, Modifier.padding(10.dp))


        val day = getTodaysDay()


                Log.i("day", day)

                Text(text = luckToday("Lunes",input))

    }

}

fun randomLuck():String {
    var luck = ""

    for (i in 1..10){
        if(Random.nextBoolean()) luck += "*"
    }

    return luck
}

fun luckToday(day:String, name:String):String{

    var counter = 0.0

    name.trim().uppercase().forEach {letter ->  if (day.uppercase().contains(letter)) counter++ }

    val luck:Double = ((counter/name.trim().length)*4).let { if (it.isNaN()) -1.0 else it }
    Log.i("luck","$luck")

    return when (luck.roundToInt()){
        0 -> "*"
        2 -> "**"
        3 -> "***"
        4 -> "****"
        else -> "*"
    }

}

fun getTodaysDay():String{

    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

    return when(day){
        1 -> "Domingo"
        2 -> "Lunes"
        3 -> "Martes"
        4 -> "Miercoles"
        5 -> "Jueves"
        6 -> "Viernes"
        7 -> "Sabado"
        else -> "Lunes"
    }


}