package yiyo.com.dashboard.data.api

import retrofit2.http.GET

interface PhotosService {

    @GET("/photos")
    fun getPhotos()
}