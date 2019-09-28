package yiyo.com.dashboard.data

import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import yiyo.com.common.utils.plusAssign
import yiyo.com.dashboard.data.models.UnsplashPhoto
import yiyo.com.dashboard.data.repositories.PhotosRepository

class PhotosDataSource(
    private val photosRepository: PhotosRepository,
    private val disposable: CompositeDisposable
) :
    PageKeyedDataSource<Int, UnsplashPhoto>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, UnsplashPhoto>
    ) {
        disposable += photosRepository.getPhotos()
            .subscribe { response -> callback.onResult(response, null, 2) }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UnsplashPhoto>) {
        disposable += photosRepository.getPhotos(params.key, params.requestedLoadSize)
            .subscribe { response -> callback.onResult(response, params.key + 1) }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UnsplashPhoto>) {

    }
}
