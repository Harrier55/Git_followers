package com.example.git_followers.app.data.mapper

import com.example.git_followers.app.data.datasource.models.UserReposGitHub
import com.example.git_followers.app.data.datasource.models.UserResultSearchName
import com.example.git_followers.app.domain.models.UserEntity
import com.example.git_followers.app.domain.models.UserProjectDescription
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object Mapper {
    private fun dateFormatter(data: String): String {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
        val date: Date = dateFormat.parse(data) as Date
        val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        return formatter.format(date)
    }

    fun mapToUserProjectDescriptionList(
        userReposGitHub: List<UserReposGitHub>
    ): List<UserProjectDescription> {
        val dataList = mutableListOf<UserProjectDescription>()
        userReposGitHub.forEach { gitHub ->
            gitHub.updatedAt?.let { dateFormatter(it) }
            dataList.add(
                UserProjectDescription(
                    id = gitHub.id,
                    userName = gitHub.name,
                    nameRepository = gitHub.name,
                    avatar_url = gitHub.owner?.avatarUrl,
                    description = gitHub.description,
                    updated_at = gitHub.updatedAt?.let { dateFormatter(it) },
                    default_branch = gitHub.defaultBranch,
                    forks_count = gitHub.forksCount,
                    stargazers_count = gitHub.stargazersCount,
                    language = gitHub.language
                )
            )
        }
        return dataList
    }

    fun mapToUserEntity(
        userResultSearchName: UserResultSearchName,
        countFollowers: Int
    ): UserEntity {
        val items = userResultSearchName.items.firstOrNull()
        return UserEntity().copy(
            id = items?.id,
            userName = items?.login,
            userImageUrl = items?.avatarUrl,
            userNumFollowers = countFollowers
        )
    }

}