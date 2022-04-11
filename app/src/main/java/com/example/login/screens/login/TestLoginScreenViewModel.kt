package com.example.login.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestLoginScreenViewModel: ViewModel() {
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private var _validateInfo = MutableLiveData(false)
    val validate: LiveData<Boolean> = _validateInfo

    fun validateLogin(
        email: String
    ): Boolean {
        val valid: Boolean = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        _validateInfo.value  = valid
        return valid
    }
}