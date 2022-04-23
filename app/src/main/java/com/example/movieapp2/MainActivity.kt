package com.example.movieapp2

import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.movieapp2.ui.theme.MovieApp2Theme

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.movieapp2.navigation.MovieNavigation


class MainActivity : ComponentActivity() {

    override fun onStart(){
        super.onStart()
        Log.i("MainActivity", "onStart called")
    }

    override fun onResume(){
        super.onResume()
        Log.i("MainActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop called")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("MainActivity", "onDestroy called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate called")

        setContent {
            MyApp{
                MovieNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    MovieApp2Theme() {
        content()
    }
}