package yiyo.com.dashboard.di

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module
import retrofit2.Retrofit
import yiyo.com.dashboard.data.PhotosDataSourceFactory
import yiyo.com.dashboard.data.api.PhotosService
import yiyo.com.dashboard.data.repositories.PhotosRepository

val dashboardModule = module {
    single { providePhotosService(get()) }
    single { PhotosRepository(get()) }
    single { PhotosDataSourceFactory(get(), CompositeDisposable()) }
}

private fun providePhotosService(retrofit: Retrofit): PhotosService {
    return retrofit.create(PhotosService::class.java)
}