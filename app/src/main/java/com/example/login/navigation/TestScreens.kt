package com.example.login.navigation

import java.lang.IllegalArgumentException

enum class TestScreens {
    SplashScreen,
    LoginScreen,
    HomeScreen;
    companion object {
        fun fromRoute(route: String): TestScreens
        = when(route?.substringBefore(delimiter = "/")) {
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            HomeScreen.name -> HomeScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route isn't recognized")
        }
    }
}