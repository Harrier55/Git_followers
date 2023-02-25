package com.example.git_followers.app.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.git_followers.R
import com.example.git_followers.app.domain.models.UserEntity
import com.example.git_followers.app.presentation.components.ImageLoader
import com.example.git_followers.app.presentation.viewmodel.MainScreenViewModel
import com.example.git_followers.app.presentation.viewmodel.MainScreenViewState
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, viewModel: MainScreenViewModel = koinViewModel()) {

    var message by remember { mutableStateOf(TextFieldValue("")) }
    val state = viewModel.viewState.observeAsState(MainScreenViewState())
    val userEntity = state.value.userEntity

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
                placeholder = ({
                    Text(text = stringResource(R.string.searg_user))
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
private fun ItemSearchedUser(userEntity: UserEntity, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(Modifier.padding(16.dp))
        {
            userEntity.userImageUrl?.let {
                ImageLoader(imageUrl = it)
            }
        }
        Spacer(Modifier.size(24.dp))
        userEntity.userName?.let { Text(text = it, style = MaterialTheme.typography.titleLarge) }
        Spacer(Modifier.size(8.dp))
        Text(
            text = stringResource(R.string.follovers) + userEntity.userNumFollowers,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(Modifier.size(8.dp))
        Button(onClick = {
            navController.navigate("repoScreen/${userEntity.userName}")
        }) {
            Text(text = stringResource(R.string.project_description))
        }
    }
}



