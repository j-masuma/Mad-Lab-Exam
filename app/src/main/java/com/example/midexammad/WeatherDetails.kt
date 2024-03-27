package com.example.midexammad

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherDetails(cityName: String,navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Weather Details")
                }
            )
        },

    ) { innerPadding ->
        val cityInput = remember {
            mutableStateOf("")
        }
        Column(


            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           Text(text = "City Name: $cityName", fontSize = 32.sp)
            Row (

            ){
                Column {
                   
                    androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.thermo), contentDescription ="" )
                }
                Column {
                    Text(text = "Humidity")
                    Text(text = "")
                }
            }
            Row (

            ){
                Column {

                    androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.baseline_wb_sunny_24), contentDescription ="" )
                }
                Column {
                    Text(text = "Condition")
                    Text(text = "")
                }
            }
            Row (

            ){
                Column {

                    androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.thermo), contentDescription ="" )
                }
                Column {
                    Text(text = "Temperature")
                    Text(text = "")
                }
            }
        }

    }
//Get Dynamic Data from Strings
/*
    val weatherInfo: List<String> = run {

        val resourceId = resources.getIdentifier("weather_info_${cityName.lowercase()}", "array", context.packageName)

        if (resourceId != 0) resources.getStringArray(resourceId).toList() else listOf("Info not available")

    }

 */
}