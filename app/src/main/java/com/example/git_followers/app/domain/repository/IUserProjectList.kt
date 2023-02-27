package com.example.git_followers.app.domain.repository

import com.example.git_followers.app.domain.models.RepositoryResult
import com.example.git_followers.app.domain.models.UserProjectDescription
import kotlinx.coroutines.flow.Flow

interface IUserProjectList {

    fun getListUserProject(userName: String): Flow<RepositoryResult.Success<List<UserProjectDescription>>>
}