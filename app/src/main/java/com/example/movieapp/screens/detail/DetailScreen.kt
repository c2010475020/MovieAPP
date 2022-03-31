package com.example.movieapp.screens.detail


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.models.Movie
import com.example.movieapp.models.getMovies
import com.example.movieapp.screens.home.MainContent
import com.example.movieapp.widgets.AccountRow
import com.example.movieapp.widgets.HorizontalScrollImageView


@Preview(showBackground = true)
@Composable
fun DetailScreen(
    navController: NavController = rememberNavController(),
    movieId: String? = "tt0499549"
){

    val movie = filterMovie(movieId = movieId)

    Scaffold(// beschreibt den ganzen screen topappbar hinterlegen.
        topBar = {
            TopAppBar(backgroundColor = Color.Gray, elevation = 3.dp){
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
        MainContent(movie = movie )
    }



}
@Composable
fun MainContent (movie: Movie){

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column {
            AccountRow(movie = movie)

            Spacer(modifier = Modifier.height(8.dp))

            Divider()

            Text(text = movie.title, style = MaterialTheme.typography.h5)

            HorizontalScrollImageView(movie = movie)

        }
    }




}
/*
title = { Text(text = "Movies X") },
                actions = {
                    IconButton(onClick = { menu = !menu }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                    }


                }
*/

fun filterMovie (movieId: String?): Movie {
    return getMovies().filter{movie -> movie.id == movieId } [0]
}