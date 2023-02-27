package com.example.git_followers.app.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.git_followers.app.domain.usecase.UserProjectListUseCase
import com.example.git_followers.app.domain.models.Status
import com.example.git_followers.app.domain.models.UserProjectDescription
import com.example.git_followers.app.utils.CheckInternet
import kotlinx.coroutines.launch

class UserProjectListViewModel(
    private val useCase: UserProjectListUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<UserProjectViewState>()
    val viewState: LiveData<UserProjectViewState> = _viewState

    fun getData(userName: String , context: Context) {
        if (userName.isNotEmpty() && CheckInternet.isOnline(context)) {
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