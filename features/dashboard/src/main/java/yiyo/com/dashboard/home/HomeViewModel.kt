package yiyo.com.dashboard.home

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import org.koin.android.ext.android.inject
import yiyo.com.dashboard.data.PhotosDataSourceFactory

class HomeViewModel(
    initialState: HomeState,
    private val dataSourceFactory: PhotosDataSourceFactory
) : MvRxViewModel<HomeState>(initialState) {

    init {
        val pagedList = RxPagedListBuilder(dataSourceFactory, PAGING_CONFIG).buildObservable()
        pagedList.execute { copy(photos = it()) }
    }

    override fun onCleared() {
        super.onCleared()
        dataSourceFactory.dispose()
    }

    companion object : MvRxViewModelFactory<HomeViewModel, HomeState> {
        val PAGING_CONFIG = PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(20)
            .setEnablePlaceholders(false)
            .build()

        override fun create(viewModelContext: ViewModelContext, state: HomeState): HomeViewModel? {
            val dataSourceFactory: PhotosDataSourceFactory by viewModelContext.activity.inject()
            return HomeViewModel(state, dataSourceFactory)
        }
    }
}