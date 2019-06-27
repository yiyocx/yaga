package yiyo.com.dashboard.data.api

import io.reactivex.Observable
import retrofit2.http.GET
import yiyo.com.dashboard.data.models.Photo

interface PhotosService {

    @GET("/photos")
    fun getPhotos(): Observable<List<Photo>>
}