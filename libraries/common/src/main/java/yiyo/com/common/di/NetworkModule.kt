package yiyo.com.common.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import yiyo.com.common.utils.AuthInterceptor
import java.util.concurrent.TimeUnit

const val SERVER_URL = "https://api.unsplash.com"
const val ACCESS_KEY = "ACCESS_KEY"

val networkModule = module {
    factory { createLoggingInterceptor() }
    factory { AuthInterceptor(getProperty(ACCESS_KEY)) }
    single { createOkHttpClient(get(), get()) }
    single { createRetrofit(get()) }
}

private fun createLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
    return httpLoggingInterceptor
}

private fun createOkHttpClient(
    loggingInterceptor: HttpLoggingInterceptor,
    authInterceptor: AuthInterceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authInterceptor)
        .build()
}

private fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(SERVER_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}
