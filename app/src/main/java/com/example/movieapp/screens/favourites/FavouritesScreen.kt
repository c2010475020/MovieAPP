package com.example.movieapp.screens.favourites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.models.Movie
import com.example.movieapp.models.getMovies
import com.example.movieapp.widgets.AccountRow


@Composable
fun FavouritesScreen(navController: NavController,movie: Movie = getMovies()[2]) {
    Scaffold(// beschreibt den ganzen screen topappbar hinterlegen.
        topBar = {
            TopAppBar(backgroundColor = Color.Gray, elevation = 3.dp) {
                Row() {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "arrow back",
                        modifier = Modifier.clickable {
                            navController.popBackStack() //geht einfach zum vorigen screen

                        })

                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = movie.title)
                }

            }
        }
    ) {
        MainContent(movie = movie)
    }
    
}
@Composable
fun MainContent(movie: Movie){
    AccountRow(movie = movie)
}