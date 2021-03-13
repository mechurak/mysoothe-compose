package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.Favorite
import com.example.androiddevchallenge.data.UserData
import com.example.androiddevchallenge.ui.theme.MyTheme


@Composable
fun HomeScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    navController: NavController? = null
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.background
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                Icons.Filled.Spa, "",
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = "HOME",
                                style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onBackground,
                            )
                        }

                    }
                    IconButton(onClick = { /* doSomething() */ }) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                Icons.Filled.AccountCircle, "",
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = "PROFILE",
                                style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onBackground,
                            )
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* doSomething() */ },
                backgroundColor = MaterialTheme.colors.primary,
            ) { Icon(Icons.Filled.PlayArrow, "") }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
    ) {
        HomeContent()
    }
}


@Composable
fun HomeContent() {
    var keyword by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {}

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
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

        // 0, 2, ...
        val evenList = UserData.favorites.filterIndexed { index, _ ->
            ((index % 2) == 0)
        }

        // 1, 3, ...
        val oddList = UserData.favorites.filterIndexed { index, _ ->
            ((index % 2) == 1)
        }

        val items = mutableListOf<FavoriteColumn>()
        for (index in oddList.indices) {
            val odd = if (index <= oddList.size - 1) oddList[index] else null
            val curColumn = FavoriteColumn(evenList[index], odd)
            items.add(curColumn)
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(items) { item ->
                    Column {
                        FavoriteItem(item.even!!)
                        Spacer(Modifier.height(8.dp))
                        if (item.odd != null) FavoriteItem(item.odd)
                    }
                }
            }
        )

        Text(
            text = "ALIGN YOUR BODY",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .paddingFromBaseline(top = 48.dp, bottom = 8.dp)
                .padding(start = 16.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(UserData.bodies) { subject ->
                    SubjectItem(subject = subject)
                }
            }
        )

        Text(
            text = "ALIGN YOUR MIND",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .padding(start = 16.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(UserData.minds) { subject ->
                    SubjectItem(subject = subject)
                }
            }
        )
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    MyTheme {
        HomeScreen()
    }
}

data class FavoriteColumn(
    val even: Favorite?,
    val odd: Favorite?
)