package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Favorite

@Composable
fun FavoriteItem(favorite: Favorite) {
    Row(
        modifier = Modifier
            .width(192.dp)
            .height(56.dp)
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colors.surface),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painterResource(id = favorite.photo),
            contentDescription = "favorite",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(56.dp)
        )
        Text(
            text = favorite.name,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
        )
    }
}