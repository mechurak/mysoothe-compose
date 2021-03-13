package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.MyTheme


@Composable
fun HomeScreen(navController: NavController? = null) {
    Column {
        Text(text = "Home screen")
        Button(onClick = { navController!!.navigate("welcome") }) {
            Text(text = "To Welcome")
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    MyTheme {
        HomeScreen()
    }
}