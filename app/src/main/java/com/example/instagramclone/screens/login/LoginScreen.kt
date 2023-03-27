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
import com.example.instagramclone.screens.login.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    onClickLogin: () -> Unit
) {


    Column(
        modifier = Modifier
            .fillMaxSize(),
//            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
//        HeaderSection()
        LoginSection(onClickLogin)
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
//            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
//        HeaderSection()
        LoginSection(onClickLogin = {})
    }
}

//
//@Composable
//private fun HeaderSection() {
//    Row() {
//        Image(
//            painter = painterResource(id = R.drawable.ic_back), contentDescription = stringResource(
//                id = R.string.back_icon
//            )
//        )
//    }
//}

@Composable
private fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.instagram),
        contentDescription = stringResource(R.string.logo_desc)
    )
}

@Composable
fun LoginSection(onClickLogin: () -> Unit) {

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val viewModel = LoginViewModel()
    val uiState by viewModel.uiState
    val scaffoldState = rememberScaffoldState() // this contains the `SnackbarHostState`
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
    ) {
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.Center
        ) {
            if (uiState.error.isNotEmpty()) {
                LaunchedEffect(scaffoldState.snackbarHostState) {
                    coroutineScope.launch {
                        val result = scaffoldState.snackbarHostState.showSnackbar(
                            message = uiState.error
                        )
                        when (result) {
                            SnackbarResult.Dismissed -> viewModel.clearError()
                            else -> {}
                        }
                    }
                }
            }

            Logo()

            TextField(
                value = uiState.email,
                onValueChange = viewModel::onEmailChange,
                label = {
                    Text(
                        text = "Số điện thoại, tên người dùng hoặc email",
                        fontSize = 13.sp
                    )
                },
                modifier = Modifier.fillMaxWidth(),
            )

            TextField(
                value = uiState.password,
                onValueChange = viewModel::onPasswordChange,
                label = {
                    Text(
                        text = "Mật khẩu",
                        fontSize = 13.sp
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(5.dp))

            Text(
                text = "Quên mật khẩu?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = {
                    viewModel.onSignInClick {
                        onClickLogin()
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Đăng nhập",
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.size(5.dp))

            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.Black)) {
                        append("Bạn chưa có tài khoản?")
                    }
                    withStyle(SpanStyle(color = Color.Blue)) {
                        append(" Đăng ký.")
                    }
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                textAlign = TextAlign.Center
            )

        }
    }


}
