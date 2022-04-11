package com.example.login.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login.components.principalTitle
import com.example.login.navigation.TestScreens
import kotlinx.coroutines.delay

@Composable
fun TestSplashScreen(
    navController: NavController
) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(targetValue = 0.9f,
                        animationSpec = tween(durationMillis = 800, easing = {
                            OvershootInterpolator(8f).getInterpolation(it)
                        }))
        delay(2000L)
        navController.navigate(TestScreens.LoginScreen.name)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primary
        ) {
        title(scale)
    }
}

@Composable
fun title(scale: Animatable<Float, AnimationVector1D>) {
    Surface(
        modifier = Modifier.scale(scale.value),
        color = MaterialTheme.colors.primary) {
        Column(modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            principalTitle()
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Franco Mercado", color= Color.Green)
        }
    }
}


