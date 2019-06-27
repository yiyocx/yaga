package yiyo.com.dashboard.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import yiyo.com.dashboard.data.api.PhotosService
import yiyo.com.dashboard.data.repositories.PhotosRepository
import yiyo.com.dashboard.ui.HomeViewModel

val dashboardModule = module {
    viewModel { HomeViewModel(get()) }
    single { providePhotosService(get()) }
    single { PhotosRepository(get()) }
}

private fun providePhotosService(retrofit: Retrofit): PhotosService = retrofit.create(PhotosService::class.java)