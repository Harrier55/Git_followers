package com.example.git_followers.app.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.git_followers.app.data.repositiry.UserRepositoryImpl
import kotlinx.coroutines.launch

class MainScreenViewModel(private val userRepository: UserRepositoryImpl): ViewModel() {

     fun onClickSearchButton(userName:String){
        Log.d("@@@", "onClickSearch: ${userName}")

         viewModelScope.launch {
             userRepository.getUser(userName).collect{

             }
         }
    }
}