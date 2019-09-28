package yiyo.com.dashboard.data.repositories

import io.reactivex.Single
import yiyo.com.dashboard.data.api.PhotosService
import yiyo.com.dashboard.data.models.UnsplashPhoto

class PhotosRepository(private val photosApi: PhotosService) {

    fun getPhotos(page: Int = 1, pageSize: Int = 10): Single<List<UnsplashPhoto>> {
        return photosApi.getPhotos(page, pageSize)
    }
}