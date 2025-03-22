package com.medpluspro.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*

import androidx.navigation.compose.rememberNavController
import com.medpluspro.presentation.screens.IntroPageScreen
import com.medpluspro.presentation.screens.LoginScreen
import com.medpluspro.presentation.screens.RegisterScreen
import com.medpluspro.presentation.screens.SplashScreen
import com.medpluspro.presentation.viewmodel.HabitViewModel

@Composable
fun MedProPlusApp() {
    val navController = rememberNavController()
    val viewModel : HabitViewModel = viewModel()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController)
        }
        composable("intro_pager") {
            IntroPageScreen(navController)
        }
        composable("login"){
            LoginScreen(navController)
        }
        composable("register"){
            RegisterScreen(navController)
        }
    }
}


