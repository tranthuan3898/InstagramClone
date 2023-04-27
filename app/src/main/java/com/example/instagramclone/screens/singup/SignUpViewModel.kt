package com.example.instagramclone.screens.singup

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramclone.model.service.impl.AccountServiceImpl
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
    var uiState = mutableStateOf(SignUpUiState())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password
    private val confirmPassword
        get() = uiState.value.confirmPassword
    private val error
        get() = uiState.value.error

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    fun onConfirmPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(confirmPassword = newValue)
    }

    fun error(newValue: String){
        uiState.value = uiState.value.copy(error = newValue)
    }
    fun onSignUpClick(onClickSignUp: () -> Unit){
        if (email.isEmpty()){
            uiState.value = uiState.value.copy(error = "Please enter email")
            return
        }

        if (password.isBlank()){
            uiState.value = uiState.value.copy(error = "Please enter password")
            return
        }

        if (password != confirmPassword){
            uiState.value = uiState.value.copy(error = "Password different confirm password")
            return
        }

        val accountService = AccountServiceImpl()

        viewModelScope.launch {
            accountService.createUser(email, password) {
                if (it?.message == null) {
                    //
                } else {
                    uiState.value = uiState.value.copy(error = it.message.toString())
                }
            }
        }
    }

    fun clearError(){
        uiState.value = uiState.value.copy(error = "")
    }

}