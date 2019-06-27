package yiyo.com.dashboard.ui

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import yiyo.com.dashboard.data.repositories.PhotosRepository

class HomeViewModel(private val photosRepository: PhotosRepository): ViewModel() {

    init {
        photosRepository.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                println(it)
            }, {
                println(it)
            })
    }
}