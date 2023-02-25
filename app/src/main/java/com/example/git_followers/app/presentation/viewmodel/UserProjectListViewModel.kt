package com.example.git_followers.app.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.git_followers.app.domain.usecase.UserRepoListUseCase
import com.example.git_followers.app.domain.models.Status
import com.example.git_followers.app.domain.models.UserProjectDescription
import kotlinx.coroutines.launch

class UserProjectListViewModel(
    private val useCase: UserRepoListUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<UserProjectViewState>()
    val viewState: LiveData<UserProjectViewState> = _viewState

    fun getData(userName: String) {
        if (userName.isNotEmpty()) {
            viewModelScope.launch {
                useCase.getUserProjectList(userName = userName).collect { repositoryResult ->
                    when (repositoryResult.status) {
                        Status.ERROR -> {}
                        Status.LOADING -> {}
                        Status.SUCCESS -> {
                            _viewState.postValue(repositoryResult.data?.let {
                                UserProjectViewState(
                                    userProjects = it,
                                    isLoading = false
                                )
                            })
                            repositoryResult.data
                        }
                    }
                }
            }
        }
    }
}

data class UserProjectViewState(
    val userProjects: List<UserProjectDescription> = listOf(),
    val isLoading: Boolean = false
)