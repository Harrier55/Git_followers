package com.example.git_followers.app.data.repositiry

import com.example.git_followers.app.data.datasource.models.ApiStatus
import com.example.git_followers.app.data.mapper.Mapper
import com.example.git_followers.app.domain.models.RepositoryResult
import com.example.git_followers.app.domain.models.UserProjectDescription
import com.example.git_followers.app.domain.repository.IUserProjectList
import kotlinx.coroutines.flow.flow

class DescriptionProjectRepositoryImpl(private val webRequest: WebRequest): IUserProjectList {

    private val listProject = mutableListOf<UserProjectDescription>()

    override fun getListUserProject(userName: String) = flow {

        if (listProject.isNotEmpty()) {
            emit(RepositoryResult.Success(listProject as List<UserProjectDescription>))
        } else {
            val result = webRequest.loadDataUserProjects(userName = userName)
            when (result.status) {
                ApiStatus.ERROR -> {}
                ApiStatus.SUCCESS -> {
                    result.data?.let { reposGitHubs ->
                        val userProject =
                            Mapper.mapToUserProjectDescriptionList(userReposGitHub = reposGitHubs)
                        emit(RepositoryResult.Success(userProject))
                    }
                }
                ApiStatus.LOADING -> {}
            }
        }
    }
}