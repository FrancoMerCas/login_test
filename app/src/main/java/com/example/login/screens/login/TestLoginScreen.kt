package com.example.login.screens.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login.components.*
import kotlinx.coroutines.launch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Close
import androidx.compose.ui.platform.LocalContext
import com.example.login.navigation.TestScreens

@ExperimentalComposeUiApi
@Composable
fun TestLoginScreen(
    navController: NavController,
    loginScreenViewModel: TestLoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        color = MaterialTheme.colors.primary) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            principalTitle()
            UserFields(loading = false) { email, pass ->
                Log.d("Login", "TestLoginScreen: $email $pass")
                loginScreenViewModel.validateLogin(email)

                if(loginScreenViewModel.validate.value == true) {
                    navController.navigate(TestScreens.HomeScreen.name)
                    Toast.makeText(context, "Succsess", Toast.LENGTH_LONG ).show()
                } else {
                    Toast.makeText(context, "Not valid format email", Toast.LENGTH_LONG ).show()
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserFields(
    loading: Boolean = false,
    onDone: (String, String) -> Unit = {email, pwd -> },
) {
    val email = rememberSaveable { mutableStateOf("")}
    val pass = rememberSaveable { mutableStateOf("")}
    val passVisibility = rememberSaveable { mutableStateOf(false)}
    val passwordFocusRequest = FocusRequester.Default
    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(email.value, pass.value) {
        email.value.trim().isNotEmpty() && pass.value.trim().isNotEmpty()
    }
    val modifier = Modifier
        .padding(top = 30.dp)
        .height(250.dp)
        .background(MaterialTheme.colors.primary)
        .verticalScroll(rememberScrollState())
    
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailInput(
            emailState = email,
            enabled = !loading,
            onAction = KeyboardActions {
            passwordFocusRequest.requestFocus()
        })
        PasswordInput(
            modifier = Modifier.focusRequester(passwordFocusRequest),
            passwordState = pass,
            labelId = "Password",
            enabled = !loading,
            passwordVisibility = passVisibility,
            onAction = KeyboardActions {
                if (!valid) return@KeyboardActions
                onDone(email.value.trim(), pass.value.trim())
            }
        )

        submintButton(
            textId = "Login",
            loading = loading,
            validInputs = valid
        ) {
            onDone(email.value.trim(), pass.value.trim())
            keyboardController?.hide()
        }
    }
}









