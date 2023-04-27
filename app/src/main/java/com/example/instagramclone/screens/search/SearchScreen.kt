package com.example.instagramclone.screens.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen() {

    var searchTerm by remember { mutableStateOf("") }


    val items = listOf(
        "https://images.pexels.com/photos/6957667/pexels-photo-6957667.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/8451490/pexels-photo-8451490.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/9132551/pexels-photo-9132551.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/7666116/pexels-photo-7666116.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/13356439/pexels-photo-13356439.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/15302394/pexels-photo-15302394.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/6195166/pexels-photo-6195166.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/6957556/pexels-photo-6957556.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/7983809/pexels-photo-7983809.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/7331967/pexels-photo-7331967.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/14251082/pexels-photo-14251082.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    )

    Scaffold() {
        Column(Modifier.padding(it)) {
            
            TextField(
                value = searchTerm,
                onValueChange = { searchTerm = it },
                textStyle = MaterialTheme.typography.subtitle1,
                placeholder = { Text("Tìm kiếm") },
                modifier = Modifier.fillMaxWidth()
            )

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                contentPadding = PaddingValues(5.dp),
                verticalItemSpacing = 5.dp,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(items) {
                    AsyncImage(
                        model = it,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun SearchScreenSection() {
    SearchScreen()
}