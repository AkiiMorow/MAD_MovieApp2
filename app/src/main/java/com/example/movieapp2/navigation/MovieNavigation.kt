package com.example.movieapp2.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp2.screens.DetailScreen
import com.example.movieapp2.screens.FavouritesScreen
import com.example.movieapp2.screens.HomeScreen
import com.example.movieapp2.viewmodels.FavouritesViewModel

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()

    val favViewModel: FavouritesViewModel = viewModel()

    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){
        composable(
            route = MovieScreens.HomeScreen.name
        ) {
            HomeScreen(navController, favViewModel)
        }

        composable(
            route= MovieScreens.DetailScreen.name + "/{movieId}",
            arguments = listOf(navArgument("movieId"){
                type = NavType.StringType
            })
        ) {
                backStackEntry -> DetailScreen(navController = navController,
            movieId = backStackEntry.arguments?.getString("movieId"),
            viewModel = favViewModel)
        }

        composable(
            route= MovieScreens.FavouritesScreen.name
        ) {
            FavouritesScreen(navController = navController, viewModel = favViewModel)
        }
    }
}