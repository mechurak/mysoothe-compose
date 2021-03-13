package com.example.androiddevchallenge.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen(navController: NavController? = null) {
    Column {
        Text(text = "Login screen")
        Button(onClick = { navController!!.navigate("home") }) {
            Text(text = "To Home")
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenPreview() {
    MyTheme {
        LoginScreen()
    }
}