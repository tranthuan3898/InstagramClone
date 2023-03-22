package com.example.instagramclone.data

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramclone.R


@Composable
fun ProfileHeader(
    backClick: () -> Unit,
    notificationClick: () -> Unit,
    optionClick: () -> Unit,
    username: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box {
            Row {
                IconButton(onClick = backClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.ic_back)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = username, fontWeight = FontWeight.Bold)
            }
        }
        ProfileHeaderOption(notificationClick = notificationClick, optionClick = optionClick)
    }
}

@Composable
private fun ProfileHeaderOption(
    modifier: Modifier = Modifier,
    notificationClick: () -> Unit,
    optionClick: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box{IconButton(onClick = notificationClick) {
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "notifications")
        }
            IconButton(onClick = optionClick) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "options")
            }}

    }
}

@Preview
@Composable
fun ProfileHeaderPreview() {
    ProfileHeader({}, {}, {}, "_cunit_")
}