package com.example.instagramclone


//import android.media.Image
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.instagramclone.data.Post
import com.example.instagramclone.data.Story


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
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
//        MainSection()
        Test()
    }
}

@Composable
fun Test() {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.White) {
                HeaderSection()
            }
        },
        bottomBar = {
            BottomNavigation(backgroundColor = Color.White) {
                NavigationSection()
            }
        })
    {
        StorySection(it)
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
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = stringResource(
                    id = R.string.ic_like
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
            .border(1.dp, Color.Gray)
            .fillMaxWidth()
            .padding(0.dp, 10.dp),
        horizontalArrangement = Arrangement.SpaceAround

    ) {
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = stringResource(id = R.string.ic_home)
        )
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = stringResource(id = R.string.ic_search)
        )
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = R.drawable.ic_save),
            contentDescription = stringResource(id = R.string.ic_save)
        )
        Image(
            painter = painterResource(id = R.drawable.profile1),
            contentDescription = stringResource(id = R.string.profile1),
            contentScale = ContentScale.Crop,                      //cắt hình ảnh nếu ko phải hình vuông
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)                                 // bo tròn hình ảnh
                .border(1.dp, Color.Red, CircleShape)
        )
    }
}


@Composable
fun StorySection(paddingValues: PaddingValues) {

}

@SuppressLint("ResourceType")
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

                        val painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.image)
                                .size(Size.ORIGINAL) // Set the target size to load the image at.
                                .build()
                        )

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

                            painter = painter,
                            contentDescription = null
                        )
                        Text(text = item.text, style = TextStyle(color = Color.Black))


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
                            contentDescription = stringResource(id = R.string.profile1)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = item.name, style = TextStyle(fontWeight = FontWeight.Medium))
                    }
                    Image(
                        modifier = Modifier.width(25.dp),
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = stringResource(id = R.string.ic_share)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))

                Image(painter = painterResource(id = item.image), contentDescription = null)

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                ) {

                    Row() {
                        Image(
                            modifier = Modifier.width(25.dp),
                            contentScale = ContentScale.FillWidth,
                            painter = painterResource(id = R.drawable.ic_like),
                            contentDescription = stringResource(id = R.string.ic_like)
                        )
                        Image(
                            modifier = Modifier.width(25.dp),
                            contentScale = ContentScale.FillWidth,
                            painter = painterResource(id = R.drawable.ic_comment),
                            contentDescription = stringResource(id = R.string.ic_comment)
                        )
                        Image(
                            modifier = Modifier.width(25.dp),
                            contentScale = ContentScale.FillWidth,
                            painter = painterResource(id = R.drawable.ic_share),
                            contentDescription = stringResource(id = R.string.ic_share)
                        )
                    }

                }

            }
        }

        item {

        }
    }
}


var postList = mutableListOf(
    Post("Raj Sing", R.drawable.profile1, image = R.drawable.post1),
    Post("Jonu", R.drawable.profile2, image = R.drawable.post2),
)

var storyList = mutableListOf(
    Story(image = "https://via.placeholder.com/200", "Your Story"),
    Story(image = "https://via.placeholder.com/200", "Sơn Tùng"),
    Story(image = "https://via.placeholder.com/200", "Sobbin"),
    Story(image = "https://via.placeholder.com/200", "Mono"),
    Story(image = "https://via.placeholder.com/200", "Đạt G"),
    Story(image = "https://via.placeholder.com/200", "Low G"),
)

