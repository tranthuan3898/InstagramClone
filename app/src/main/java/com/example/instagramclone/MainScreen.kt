package com.example.instagramclone

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagramclone.screens.profile.ProfileScreen

data class NavItem(val route: String, val icon: ImageVector)

@Composable
fun MainScreen() {

    val navController: NavHostController = rememberNavController()

    var selectedItem by remember { mutableStateOf(0) }


    val items = arrayListOf(
        NavItem(route = Home.route, icon = Icons.Filled.Home),
        NavItem(route = Home.route, icon = Icons.Filled.Search),
        NavItem(route = Home.route, icon = Icons.Outlined.Add),
        NavItem(route = Home.route, icon = Icons.Filled.Check),
        NavItem(route = Profile.route, icon = Icons.Filled.Person),
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = Color.White) {
                items.forEachIndexed { index, navItem ->
                    BottomNavigationItem(
                        selected = index == selectedItem,
                        onClick = {
                            selectedItem = index
                            navController.navigate(navItem.route)
                                  },
                        icon = { Icon(navItem.icon, contentDescription = null) }
                    )
                }

            }
        })
    {
//        StorySection(it)
//        PostSection()


        NavHost(modifier = Modifier.padding(it), navController = navController, startDestination = "home"){
            composable(Home.route) { HomeScreen() }
            composable(Profile.route) { ProfileScreen() }
        }
    }
}