package yiyo.com.dashboard.data

import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import yiyo.com.dashboard.data.models.UnsplashPhoto
import yiyo.com.dashboard.data.repositories.PhotosRepository

class PhotosDataSourceFactory(
    private val photosRepository: PhotosRepository,
    private val disposable: CompositeDisposable
) :
    DataSource.Factory<Int, UnsplashPhoto>() {

    override fun create(): DataSource<Int, UnsplashPhoto> {
        return PhotosDataSource(photosRepository, disposable)
    }

    fun dispose() = disposable.dispose()
}