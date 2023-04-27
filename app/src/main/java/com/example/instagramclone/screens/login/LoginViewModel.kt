package com.example.instagramclone.screens.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramclone.model.service.impl.AccountServiceImpl
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel(){

    var uiState = mutableStateOf(LoginUiState())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password
    private val error
        get() = uiState.value.error

    fun onEmailChange(newValue: String) {
        Log.d("AAA", newValue)
        uiState.value = uiState.value.copy(email = newValue)
    }
    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }
    fun error(newValue: String){
        uiState.value = uiState.value.copy(error = newValue)
    }
    fun onSignInClick(onClickSuccess: () -> Unit){
        if (email.isEmpty()){
           uiState.value = uiState.value.copy(error = "Please enter email")
           return
        }

        if (password.isBlank()){
            uiState.value = uiState.value.copy(error = "Please enter password")
            return
        }

        val accountService = AccountServiceImpl()

        viewModelScope.launch {
            accountService.authenticate(email, password) {
                if (it?.message == null) {
                    onClickSuccess()
                } else {
                    uiState.value = uiState.value.copy(error = it?.message.toString())
                }
            }
        }
    }
    fun clearError(){
        uiState.value = uiState.value.copy(error = "")
    }

}