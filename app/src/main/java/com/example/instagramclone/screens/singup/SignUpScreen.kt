package com.example.instagramclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignUpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        SignUpSection()
    }
}

@Composable
@Preview

fun SignUpScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        SignUpSection()
    }
}

@Composable
private fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.instagram),
        contentDescription = stringResource(R.string.logo_desc)
    )
}

@Composable
fun SignUpSection() {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }

    Logo()



    TextField(
        value = username,
        onValueChange = { username = it },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text("Tên đăng nhập")
        }
    )

    TextField(
        value = password,
        onValueChange = { password = it },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        label = {
            Text(text = "Mật khẩu",)
        }
    )
    TextField(
        value = confirmPassword,
        onValueChange = { confirmPassword = it },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        label = {
            Text(text = "Nhập lại mật khẩu")
        }
    )
    Button(onClick = {
        //your onclick code here
    }, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Đăng ký")
    }

}
