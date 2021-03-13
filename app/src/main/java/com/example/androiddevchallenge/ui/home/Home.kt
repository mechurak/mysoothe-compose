package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.ui.theme.MyTheme


@Composable
fun HomeScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    navController: NavController? = null
) {
    var keyword by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {}

    Column {
        TextField(
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "search",
                    modifier = Modifier.size(18.dp)
                )
            },
            placeholder = { Text("Search") },
            value = keyword,
            onValueChange = { keyword = it },
            textStyle = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
            modifier = Modifier
                .padding(top = 56.dp, start = 16.dp, end = 16.dp)
                .height((56).dp)
                .fillMaxWidth()
        )

        Text(
            text = "FAVORITE COLLECTIONS",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .paddingFromBaseline(top = 48.dp, bottom = 8.dp)
                .padding(start = 16.dp)
        )

        // List

        Text(
            text = "ALIGN YOUR BODY",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .paddingFromBaseline(top = 48.dp, bottom = 8.dp)
                .padding(start = 16.dp)
        )

        // List

        Text(
            text = "ALIGN YOUR MIND",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .paddingFromBaseline(top = 48.dp, bottom = 8.dp)
                .padding(start = 16.dp)
        )

        // List
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    MyTheme {
        HomeScreen()
    }
}