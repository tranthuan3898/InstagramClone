package com.example.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagramclone.ui.theme.InstagramCloneTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()
            NavHost(
                modifier = Modifier,
                navController = navController,
                startDestination = "login"
            ) {
                composable("main") { MainScreen() }
                composable("login") {
                    LoginScreen(navController)
                }
                composable("signup") { SignUpScreen() }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InstagramCloneTheme {
        Greeting("Android")
    }
}

