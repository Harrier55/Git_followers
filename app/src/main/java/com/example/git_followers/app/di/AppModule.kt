package com.example.git_followers.app.di


import com.example.git_followers.app.data.repositiry.UserRepositoryImpl
import com.example.git_followers.app.data.datasource.Api
import com.example.git_followers.app.data.datasource.WebRequest
import com.example.git_followers.app.data.repositiry.DescriptionProjectRepositoryImpl
import com.example.git_followers.app.domain.usecase.UserRepoListUseCase
import com.example.git_followers.app.domain.usecase.UserSearchUseCase
import com.example.git_followers.app.presentation.viewmodel.MainScreenViewModel
import com.example.git_followers.app.presentation.viewmodel.UserProjectListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val BASEURL = "https://api.github.com/"

object AppModule {

    /** Repositories **/
    val mainModule = module {
        single { UserRepositoryImpl(webRequest = get()) }
        single { WebRequest(webApi = get()) }
        single { DescriptionProjectRepositoryImpl(webRequest = get()) }
        single { UserRepoListUseCase(repository = get()) }
        single { UserSearchUseCase(userRepository = get()) }

        /** ViewModels */
        viewModel { MainScreenViewModel(useCase = get()) }
        viewModel { UserProjectListViewModel(useCase = get()) }
    }


    /** Клиент Retrofit сразу с интерфейсом */
    val apiModule = module {
        single {
            Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }
    }

}