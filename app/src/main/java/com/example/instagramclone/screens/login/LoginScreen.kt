package com.example.instagramclone

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Logo()
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        HeaderSection()
        LoginSection()
        FooterSection()
    }
}


@Composable
private fun HeaderSection () {
    Row() {
        Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = stringResource(
            id = R.string.back_icon
        ))
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
fun LoginSection() {

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.Top) {

        Logo()

        TextField(
            value = username,
            onValueChange = { username = it },
            label = {
                Text(
                    text = "Số điện thoại, tên người dùng hoặc email",
                    fontSize = 13.sp
                )
            },
            modifier = Modifier.fillMaxWidth(),
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Mật khẩu", fontSize = 13.sp) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.size(5.dp))

        Text(
            text = "Quên mật khẩu?",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Đăng nhập",
                color = Color.White
            )
        }
    }
}

@Composable
fun FooterSection() {
    Text(buildAnnotatedString {
        withStyle(SpanStyle(color = Color.White)) {
            append("Bạn chưa có tài khoản ư?")
        }
        withStyle(SpanStyle(color = Color.Blue)) {
            append(" Đăng ký.")
        }
    })
}