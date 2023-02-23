package com.example.git_followers.app.data.mapper

import com.example.git_followers.app.data.datasource.models.UserReposGitHub
import com.example.git_followers.app.data.datasource.models.UserResultSearchName
import com.example.git_followers.app.domain.models.UserEntity
import com.example.git_followers.app.domain.models.UserProjectDescription

object Mapper {

    fun mapToUserProjectDescriptionList(
        userReposGitHub: List<UserReposGitHub>
    ): List<UserProjectDescription> {
        val dataList = mutableListOf<UserProjectDescription>()
        userReposGitHub.forEach { userReposGitHub ->
            dataList.add(
                UserProjectDescription(
                    id = userReposGitHub.id,
                    userName = userReposGitHub.name,
                    nameRepository = userReposGitHub.name,
                    avatar_url = userReposGitHub.owner?.avatarUrl,
                    description = userReposGitHub.description,
                    updated_at = userReposGitHub.updatedAt,
                    default_branch = userReposGitHub.defaultBranch,
                    forks_count = userReposGitHub.forksCount,
                    stargazers_count = userReposGitHub.stargazersCount,
                    language = userReposGitHub.language
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