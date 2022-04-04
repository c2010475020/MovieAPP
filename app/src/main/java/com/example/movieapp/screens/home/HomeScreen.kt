package com.example.movieapp.screens.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.MyApp
import com.example.movieapp.models.Movie
import com.example.movieapp.models.getMovies
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.ui.theme.MovieAPPTheme
import com.example.movieapp.widgets.AccountRow

/*
class HomeScreen {
}*/

@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {

    var menu by remember {
        mutableStateOf(false)
    }


    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Movies") },
                actions = {
                    IconButton(onClick = { menu = !menu }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                    }

                    DropdownMenu(expanded = menu, onDismissRequest = { menu = false }) {
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            Row {
                                IconButton(onClick = { navController.navigate(MovieScreens.FavouritesScreen.name) }) {
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "Favorites",
                                        modifier = Modifier.padding(4.dp)
                                    )
                                    Text(
                                        text = "Favorites",
                                        modifier = Modifier
                                            .padding(4.dp)
                                            .width(100.dp)
                                    )
                                }

                            }
                        }
                    }
                }
            )
        }
    ){
        MainContent(navController = navController, movieList = getMovies())
    }
}



@Composable
fun MainContent(navController: NavController, movieList: List<Movie>) {

    LazyColumn{
        items(movieList) { movie ->
            AccountRow(movie = movie){ movieId ->
                navController.navigate(route = MovieScreens.DetailScreen.name + "/$movieId")

            }
        }
    }
}
