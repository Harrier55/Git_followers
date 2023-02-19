package com.example.git_followers.app.data.mapper

import com.example.git_followers.app.data.datasource.models.UserResultSearchName
import com.example.git_followers.app.domain.models.UserEntity

object Mapper {

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