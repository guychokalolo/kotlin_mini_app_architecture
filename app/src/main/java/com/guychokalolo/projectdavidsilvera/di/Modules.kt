package com.guychokalolo.projectdavidsilvera.di

import com.guychokalolo.projectdavidsilvera.data.network.api.LocalApi
import com.guychokalolo.projectdavidsilvera.data.network.api.LocalApiImpl
import com.guychokalolo.projectdavidsilvera.data.network.api.RemoteApi
import com.guychokalolo.projectdavidsilvera.data.database.createDatabase
import com.guychokalolo.projectdavidsilvera.data.database.createProductDao
import com.guychokalolo.projectdavidsilvera.data.network.createApiClient
import com.guychokalolo.projectdavidsilvera.data.repository.ProductRepositoryImp
import com.guychokalolo.projectdavidsilvera.data.repository.UserRepositoryImpl
import com.guychokalolo.projectdavidsilvera.domain.repository.ProductRepository
import com.guychokalolo.projectdavidsilvera.domain.repository.UserRepository
import com.guychokalolo.projectdavidsilvera.domain.usecase.ProductUseCase
import com.guychokalolo.projectdavidsilvera.domain.usecase.UserUseCase
import com.guychokalolo.projectdavidsilvera.presentation.feature.main.viewmodel.HistoryViewModel
import com.guychokalolo.projectdavidsilvera.presentation.feature.main.viewmodel.HomeViewModel
import com.guychokalolo.projectdavidsilvera.presentation.feature.main.viewmodel.ScanViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModules by lazy {
    listOf(
        viewModelModule,
        useCaseModule,
        repositoryModule,
        dataModule
    )
}

val viewModelModule: Module = module {
    viewModel { ScanViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { HistoryViewModel(get()) }
}

val useCaseModule: Module = module {
    single { ProductUseCase(productRepository = get(), userRepository = get()) }
    single { UserUseCase(userRepository = get()) }
}
val repositoryModule: Module = module {
    single { ProductRepositoryImp(remoteApi = get(), productDao = get()) as ProductRepository }
    single { UserRepositoryImpl(localApi = get()) as UserRepository }
}

val dataModule: Module = module {
    //singleton for retrofit
    single { createApiClient().create(RemoteApi::class.java) }
    //singleton for room and dao
    single { createDatabase(appContext = get()) }
    single { createProductDao(database = get()) }
    // single for sharedPreference
    single<LocalApi> { LocalApiImpl(appContext = get()) }
}