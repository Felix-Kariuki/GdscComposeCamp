package com.flexcode.gdsckabarak.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.flexcode.gdsckabarak.common.utils.isNameValid

class LoginViewModel : ViewModel() {

    var uiState = mutableStateOf(LoginUiState())
        private set

    private val name
        get() = uiState.value.name

    private val password
        get() = uiState.value.password

    fun onNameChange(value: String) {
        uiState.value = uiState.value.copy(name = value)
    }

    fun onPasswordChange(value: String) {
        uiState.value = uiState.value.copy(password = value)
    }


    fun navigateToHome(navigateToHome: () -> Unit) {
        if (!name.isNameValid()) {
            //snackbar
            return
        }
        /*if (!password.isValidPassword()) {
            //snackbar
            return
        }*/
        navigateToHome()
    }

}