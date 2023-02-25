package com.example.git_followers.app.domain.usecase

import com.example.git_followers.app.data.repositiry.DescriptionProjectRepositoryImpl
import com.example.git_followers.app.domain.models.RepositoryResult
import com.example.git_followers.app.domain.models.UserProjectDescription
import kotlinx.coroutines.flow.Flow

class UserRepoListUseCase(
    private val repository: DescriptionProjectRepositoryImpl
) {
    fun getUserProjectList(userName: String): Flow<RepositoryResult.Success<List<UserProjectDescription>>> {
        return repository.getListUserProject(userName = userName)
    }
}