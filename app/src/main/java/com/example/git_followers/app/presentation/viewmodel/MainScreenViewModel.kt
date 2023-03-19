package com.example.git_followers.app.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.git_followers.app.domain.usecase.UserSearchUseCase
import com.example.git_followers.app.domain.models.Status
import com.example.git_followers.app.domain.models.UserEntity
import com.example.git_followers.app.utils.CheckInternet
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val useCase: UserSearchUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<MainScreenViewState>()
    val viewState: LiveData<MainScreenViewState> = _viewState

    fun onClickSearchButton(userName: String, context: Context) {

        if (userName.isNotEmpty() && CheckInternet.isOnline(context)) {
            viewModelScope.launch {
                useCase.execute(userName).collect { repositoryResult ->
                    when (repositoryResult.status) {
                        Status.ERROR -> {}
                        Status.LOADING -> {}
                        Status.SUCCESS -> {
                            _viewState.postValue(
                                repositoryResult.data?.let {
                                    MainScreenViewState(
                                        userEntity = it,
                                        isLoading = false
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

data class MainScreenViewState(
    val userEntity: UserEntity? = null,
    val isLoading: Boolean = false
)