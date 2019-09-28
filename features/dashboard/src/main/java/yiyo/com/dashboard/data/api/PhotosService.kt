package yiyo.com.dashboard.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import yiyo.com.dashboard.data.models.UnsplashPhoto

interface PhotosService {

    @GET("/photos")
    fun getPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") pageSize: Int = 10
    ): Single<List<UnsplashPhoto>>
}