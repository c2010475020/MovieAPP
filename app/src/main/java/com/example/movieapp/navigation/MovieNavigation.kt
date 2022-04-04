package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.detail.DetailScreen
import com.example.movieapp.screens.favourites.FavouritesScreen
import com.example.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){ HomeScreen(navController = navController)} // verlinkung homescreen soll HomeScreen sein


        composable(MovieScreens.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument("movie"){
                type = NavType.StringType
            })
        ){ backStackEntry -> //so können wir uns unsere Argumente holen

            // ? heißt wenns eben nicht null ist  dann hol dir den string von movie
            DetailScreen(navController = navController, movieId = backStackEntry.arguments?.getString("movie") )
        }
        composable(MovieScreens.FavouritesScreen.name){ FavouritesScreen(navController = navController)}
        //man kann hier mehr routen/screens  adden
    }

}


