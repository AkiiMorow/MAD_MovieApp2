package com.example.movieapp2.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp2.widgets.FavouritesIcon
import com.example.movieapp2.widgets.MovieRow
import com.example.movieapp2.widgets.TopAppBarDropdownMenu
import com.example.movieapp2.models.Movie
import com.example.movieapp2.models.getMovies
import com.example.movieapp2.navigation.MovieScreens
import com.example.movieapp2.viewmodels.FavouritesViewModel


@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavController = rememberNavController(), viewModel: FavouritesViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Movies")
                }, actions = {
                    TopAppBarDropdownMenu(navController = navController)
                })
        }) {
        MainContent(navController = navController, viewModel = viewModel)
    }
}

@Composable
fun MainContent(navController: NavController,
                viewModel: FavouritesViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
                movieList: List<Movie> = getMovies()){
    LazyColumn {
        items(movieList) { movie ->
            MovieRow(
                movie = movie,
                onItemClick = { movieId ->
                    navController.navigate(route = MovieScreens.DetailScreen.name + "/$movieId") }
            ) {
                FavouritesIcon(isFav = viewModel.isFavourite(movie), movie = movie){
                        m->
                    if(viewModel.isFavourite(m)){
                        viewModel.removeFav(m)
                    }
                    else {
                        viewModel.addFav(m)
                    }
                }
            }
        }
    }
}