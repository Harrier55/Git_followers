package com.example.git_followers.app.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ItemUser() {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray)
        )
        {
            // todo Image
        }
        Column(Modifier.padding(start = 16.dp))
        {
            Text(text = "Имя ", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.size(8.dp))
            Text(text = "Подписчиков 9 ", style = MaterialTheme.typography.bodyLarge)

        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(end = 8.dp),
            horizontalArrangement = Arrangement.End
        )
        {
            Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Red)
        }
    }
}