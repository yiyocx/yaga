package yiyo.com.dashboard.data.repositories

import io.reactivex.Observable
import yiyo.com.dashboard.data.api.PhotosService
import yiyo.com.dashboard.data.models.Photo

class PhotosRepository(private val photosApi: PhotosService) {

    fun getPhotos(): Observable<List<Photo>> = photosApi.getPhotos()
}