package com.example.git_followers.app.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.git_followers.app.data.repositiry.UserRepositoryImpl
import com.example.git_followers.app.domain.models.Status
import kotlinx.coroutines.launch

class MainScreenViewModel(private val userRepository: UserRepositoryImpl) : ViewModel() {

    private val _viewState = MutableLiveData<MainScreenViewState>()
    val viewState: LiveData<MainScreenViewState> = _viewState

    fun onClickSearchButton(userName: String) {
        if (userName.isNotEmpty()) {
            viewModelScope.launch {
                userRepository.getUser(userName).collect { repositoryResult ->
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