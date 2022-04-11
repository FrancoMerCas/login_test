package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.screens.TestSplashScreen
import com.example.login.screens.home.TestHomeScreen
import com.example.login.screens.login.TestLoginScreen

@ExperimentalComposeUiApi
@Composable
fun TestNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
            startDestination = TestScreens.SplashScreen.name
    ) {
        composable(TestScreens.SplashScreen.name) {
            TestSplashScreen(navController = navController)
        }
        composable(TestScreens.HomeScreen.name) {
            TestHomeScreen(navController = navController)
        }
        composable(TestScreens.LoginScreen.name) {
            TestLoginScreen(navController = navController)
        }
    }
}