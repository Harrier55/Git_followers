package com.example.git_followers.app.domain.usecase

import com.example.git_followers.app.domain.repository.IUserProjectList
import com.example.git_followers.app.domain.models.RepositoryResult
import com.example.git_followers.app.domain.models.UserProjectDescription
import kotlinx.coroutines.flow.Flow

class UserProjectListUseCase(
    private val repository: IUserProjectList
) {
    fun execute(userName: String): Flow<RepositoryResult.Success<List<UserProjectDescription>>> {
        return repository.getListUserProject(userName = userName)
    }
}