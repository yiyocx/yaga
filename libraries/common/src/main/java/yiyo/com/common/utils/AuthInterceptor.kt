package yiyo.com.common.utils

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val accessToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request.newBuilder()
            .addHeader("Authorization", "Client-ID $accessToken")
            .build()
        return chain.proceed(authenticatedRequest)
    }
}