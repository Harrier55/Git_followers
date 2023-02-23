package com.example.git_followers.app.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.git_followers.app.domain.models.UserProjectDescription
import com.example.git_followers.app.presentation.components.ImageLoader
import com.example.git_followers.app.presentation.viewmodel.UserProjectListViewModel
import com.example.git_followers.app.presentation.viewmodel.UserProjectViewState
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun UserProjectListScreen(user: String ,viewModel: UserProjectListViewModel = koinViewModel()) {
    val viewState = viewModel.viewState.observeAsState(UserProjectViewState())
    viewModel.getData(user)
    val listItems: List<UserProjectDescription> = viewState.value.userProjects

    Column(
        Modifier.verticalScroll(rememberScrollState())
    )
    {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
            Text(text = "Описание проектов",style = MaterialTheme.typography.titleLarge)
        }

        listItems.forEach { userProject ->
            ItemUserProject(userProject = userProject)
            Divider(Modifier.padding(8.dp), thickness = 1.dp, color = Color.Black)
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ItemUserProject(userProject: UserProjectDescription) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .size(150.dp)
        ) {
            userProject.avatar_url?.let { ImageLoader(imageUrl = it) }
        }
        userProject.nameRepository?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(Modifier.size(16.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            Text(
                text = "Описание проекта: ${userProject.description}",
                Modifier.padding(vertical = 8.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Row(Modifier.fillMaxWidth()) {
            Column(
                Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = "Последний коммит: ",
                    Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Основная ветка проекта: ",
                    Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Количество форков: ",
                    Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Количество звезд: ",
                    Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Язык программирования: ",
                    Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Column()
            {
                userProject.updated_at?.let {commit->

                    Text(
                        text = commit,
                        Modifier.padding(vertical = 8.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                userProject.default_branch?.let {
                    Text(
                        text = it,
                        Modifier.padding(vertical = 8.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                userProject.forks_count?.toString()?.let {
                    Text(
                        text = it,
                        Modifier.padding(vertical = 8.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                userProject.stargazers_count?.toString()?.let {
                    Text(
                        text = it,
                        Modifier.padding(vertical = 8.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                userProject.language?.let {
                    Text(
                        text = it,
                        Modifier.padding(vertical = 8.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

