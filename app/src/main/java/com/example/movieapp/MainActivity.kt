package com.example.movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.ui.theme.MovieAPPTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.example.movieapp.navigation.MovieNavigation
import com.example.movieapp.screens.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "On Start")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "On Destroy")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "On Pause")

    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "On Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "On Restart")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    MovieNavigation()
                    // HomeScreen()
                    //MainContent(movieList = getMovies())
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){


   MovieAPPTheme() {
        content()
    }

}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        HomeScreen()
        //MainContent(movieList = getMovies())
    }
}

