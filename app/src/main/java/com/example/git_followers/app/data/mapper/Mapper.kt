package com.example.git_followers.app.data.mapper

import com.example.git_followers.app.data.datasource.UserResultSearchName
import com.example.git_followers.app.domain.models.UserEntity

object Mapper {

    fun mapToUserEntity(userResultSearchName: UserResultSearchName):UserEntity{

        return UserEntity()
    }

}