package yiyo.com.dashboard.home

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import yiyo.com.dashboard.data.repositories.PhotosRepository

class HomeViewModel(private val photosRepository: PhotosRepository) : ViewModel() {

    fun observePhotos() = photosRepository.getPhotos()
}