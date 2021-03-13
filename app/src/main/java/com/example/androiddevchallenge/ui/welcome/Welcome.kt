package com.example.androiddevchallenge.ui.welcome


import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(navController: NavController? = null) {
    Column {
        Text(text = "Welcome screen")
        Button(onClick = { navController!!.navigate("login") }) {
            Text(text = "To login")
        }
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenPreview() {
    MyTheme {
        WelcomeScreen()
    }
}