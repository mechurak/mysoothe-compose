/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    navController: NavController? = null
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        // TODO: How to use status bar as well
        Image(
            painterResource(id = if (darkTheme) R.drawable.dark_welcome else R.drawable.light_welcome),
            contentDescription = "bg",
            contentScale = ContentScale.FillHeight
        )
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painterResource(id = if (darkTheme) R.drawable.dark_logo else R.drawable.light_logo),
            contentDescription = "logo",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Button(
            onClick = { navController!!.navigate("login") },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .height(72.dp)
        ) {
            Text(
                text = "SIGN UP",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.button,
            )
        }
        Button(
            onClick = { navController!!.navigate("login") },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .height(72.dp)
        ) {
            Text(
                text = "LOG IN",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.button,
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenLightPreview() {
    MyTheme {
        WelcomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenDarkPreview() {
    MyTheme {
        WelcomeScreen(darkTheme = true)
    }
}
