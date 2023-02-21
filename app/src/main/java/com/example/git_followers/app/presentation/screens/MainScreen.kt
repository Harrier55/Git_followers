package com.example.git_followers.app.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.git_followers.app.domain.models.UserEntity
import com.example.git_followers.app.presentation.viewmodel.MainScreenViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(navController: NavController, viewModel: MainScreenViewModel = koinViewModel()) {

    val focusManager = LocalFocusManager.current

    var message by remember { mutableStateOf(TextFieldValue("")) }
    val state = viewModel.viewState.observeAsState()
    val userEntity = state.value?.userEntity

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.size(8.dp))
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = message,
                onValueChange = {
                    message = it
                },
                Modifier.fillMaxWidth(),
                trailingIcon = {
                    Button(
                        onClick = {
                            viewModel.onClickSearchButton(message.text)
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            tint = Color.Black,
                            contentDescription = null
                        )
                    }
                },
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                placeholder = ({
                    Text(text = "Найти пользователя GitHub")
                }),
                singleLine = true,
                maxLines = 12
            )
        }
        Spacer(Modifier.size(8.dp))
        userEntity?.let { userEntity ->
            ItemSearchedUser(userEntity, navController)
        }
    }
}

@Composable
fun ItemSearchedUser(userEntity: UserEntity, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box()
        {
            userEntity.userImageUrl?.let {
                ImageLoader(imageUrl = it)
            }
        }
        Spacer(Modifier.size(24.dp))
        userEntity.userName?.let { Text(text = it, style = MaterialTheme.typography.titleLarge) }
        Spacer(Modifier.size(8.dp))
        Text(
            text = "Подписчиков ${userEntity.userNumFollowers} ",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(Modifier.size(8.dp))
        Button(onClick = {
            navController.navigate("repoScreen")
        }) {
            Text(text = "Подробнее")
        }
    }
}

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

/** Загрузка изображения**/
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ImageLoader(imageUrl: String) {
    GlideImage(
        model = imageUrl,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    ) {
        it.diskCacheStrategy(DiskCacheStrategy.ALL)
    }
}