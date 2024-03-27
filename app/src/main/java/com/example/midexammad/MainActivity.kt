package com.example.midexammad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.midexammad.ui.theme.MidExamMADTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidExamMADTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp(){

    val navController= rememberNavController()
    NavHost(navController = navController,

        startDestination = "CitySelection"){
        composable(route="MainScreen"){
            SplashScreenA(navController)
        }
        composable(route = "CitySelection"){

            CitySelection(navController)
        }


        composable("MainScreen"+"/{name}"){
            val name= it.arguments?.getString("name")
            WeatherDetails(name?:"noName",navController)
        }
    }
}

@Composable
fun Greeting(navController: NavController, modifier: Modifier = Modifier) {
    Text(
        text = "Hello !",
        modifier = modifier
    )

}

@Composable
fun SplashScreenA(navController: NavController){
    LaunchedEffect(Unit) {

        delay(3000) // Wait for 3 seconds

        // code to be called after 3 seconds
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription ="Logo" )
            Text(text = "Sky Sight")
            Button(onClick = {
                navController.navigate("CitySelection")
            }) {
                Text("Select City")
            }
        }
    }

}
/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MidExamMADTheme {
        Greeting(navController = NavController())
    }
}

 */