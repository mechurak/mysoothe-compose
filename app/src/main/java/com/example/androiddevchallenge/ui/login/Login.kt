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
package com.example.androiddevchallenge.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    navController: NavController? = null
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        // TODO: How to use status bar as well
        Image(
            painterResource(id = if (darkTheme) R.drawable.dark_login else R.drawable.light_login),
            contentDescription = "bg",
            contentScale = ContentScale.FillHeight
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "LOG IN",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .paddingFromBaseline(top = 200.dp, bottom = 32.dp)
                .fillMaxWidth()
        )

        TextField(
            placeholder = { Text("Email address") },
            value = email,
            onValueChange = { email = it },
            textStyle = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .height((56).dp)
                .fillMaxWidth()
        )

        TextField(
            placeholder = { Text("Password") },
            value = password,
            onValueChange = { password = it },
            textStyle = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .height((56).dp)
                .fillMaxWidth()
        )

        Button(
            onClick = { navController!!.navigate("home") },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
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

        Text(
            text = buildAnnotatedString {
                append("Don't have an account? ")
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("Sign up")
                }
            },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .paddingFromBaseline(top = 32.dp)
                .fillMaxWidth()

        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenPreview() {
    MyTheme {
        LoginScreen()
    }
}
