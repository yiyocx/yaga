package yiyo.com.dashboard.home

import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject
import yiyo.com.dashboard.data.repositories.PhotosRepository

class HomeViewModel(
    initialState: HomeState,
    photosRepository: PhotosRepository
) : MvRxViewModel<HomeState>(initialState) {

    init {
        photosRepository.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .execute { copy(photos = it().orEmpty()) }
    }

    companion object : MvRxViewModelFactory<HomeViewModel, HomeState> {
        override fun create(viewModelContext: ViewModelContext, state: HomeState): HomeViewModel? {
            val photosRepository: PhotosRepository by viewModelContext.activity.inject()
            return HomeViewModel(state, photosRepository)
        }
    }
}