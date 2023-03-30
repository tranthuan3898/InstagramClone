package com.example.instagramclone

import androidx.compose.runtime.Composable
import com.example.instagramclone.screens.profile.ProfileScreen


interface Destination {
    val route: String
    val screen: @Composable () -> Unit
}

object Home : Destination {
    override val route: String
        get() = "home"
    override val screen: @Composable () -> Unit
        get() = {  }
}

object Profile : Destination {
    override val route: String
        get() = "profile"
    override val screen: @Composable () -> Unit
        get() = {  }
}

object SignUp : Destination {
    override val route: String
        get() = "signup"
    override val screen: @Composable () -> Unit
        get() = {  }
}

object Login : Destination {
    override val route: String
        get() = "login"
    override val screen: @Composable () -> Unit
        get() = {  }
}

object Reels : Destination {
    override val route: String
        get() = "reels"
    override val screen: @Composable () -> Unit
        get() = {  }
}

object Search : Destination {
    override val route: String
        get() = "search"
    override val screen: @Composable () -> Unit
        get() = {  }
}