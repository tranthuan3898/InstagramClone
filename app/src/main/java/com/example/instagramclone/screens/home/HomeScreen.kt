package com.example.instagramclone


import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

    }

}

@Composable
@Preview
fun HomeScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
//        .background(color = Color.White)
    ) {
        MainSection()
        NavigationSection()
    }
}

@Composable
private fun MainSection() {
    Column() {
        HeaderSection()
        StorySection()
        PostSection()
    }
}

@Composable
private fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.instagram),
        contentDescription = stringResource(R.string.logo_desc)
    )
}

@Composable
private fun HeaderSection() {
    Row(
        modifier = Modifier
            .background(
                color = Color.Green
            )
            .fillMaxWidth()
            .height(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Logo()
        Row() {
            Image(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.ic_add_story),
                contentDescription = stringResource(
                    id = R.string.ic_add_story,
//                    with(140.dp)
                )
            )
            Image(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = stringResource(
                    id = R.string.ic_favorite
                )
            )

            Image(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.ic_message),
                contentDescription = stringResource(
                    id = R.string.ic_message
                )
            )

        }

    }


}


@Composable
fun NavigationSection() {
    Row(
        modifier = Modifier
            .background(Color.White)
            .border(1.dp, Color.Gray)
            .fillMaxWidth()
            .padding(0.dp, 10.dp),
        horizontalArrangement = Arrangement.SpaceAround

    ) {
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "home"
        )
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search"
        )
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = R.drawable.ic_save),
            contentDescription = "save"
        )
        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,                      //cắt hình ảnh nếu ko phải hình vuông
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)                                 // bo tròn hình ảnh
                .border(1.dp, Color.Red, CircleShape)
        )
    }
}


@Composable
fun StorySection() {

}

@Composable
fun PostSection() {
    LazyColumn() {
        item {
            LazyRow() {
                items(storyList) { item ->
                    Column(
                        Modifier.padding(10.dp, 9.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        // cho nay modifier bi loi, copy code
                        Image(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .border(
                                    1.dp, Color.Red,
                                    CircleShape
                                )
                                .padding(3.dp)
                                .clip(CircleShape)
                                .border(
                                    2.dp, Color.White,
                                    CircleShape
                                ),

                            painter = painterResource(id = item.profile),
                            contentDescription = null
                        )
                        Text(text = item.name, style = TextStyle(color = Color.Black))


                    }
                }
            }
        }
        items(postList) { item ->
            Column(Modifier.padding(0.dp, 10.dp)) {
                Row(
                    Modifier
                        .padding(10.dp, 0.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .size(45.dp)
                                .padding(3.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Red),
                            painter = painterResource(id = item.profile),
                            contentDescription = "profile"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = item.name, style = TextStyle(fontWeight = FontWeight.Medium))
                    }
                    Image(
                        modifier = Modifier.width(25.dp),
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = "share"
                    )
                }
            }
        }
    }
}

data class Post(val name: String, val profile: Int, val image: Int)

var postList = mutableListOf(
    Post("Raj Sing", R.drawable.profile1, image = R.drawable.post1),
    Post("Jonu", R.drawable.profile2, image = R.drawable.post2),
)

data class Story(val name: String, val profile: Int);
var storyList = mutableListOf(
    Story("Your Story", R.drawable.profile1),
    Story("Sơn Tùng", R.drawable.profile2),
    Story("Sobbin", R.drawable.profile3),
    Story("Mono", R.drawable.profile4),
    Story("Đạt G", R.drawable.profile5),
    Story("Low G", R.drawable.profile6),
)

