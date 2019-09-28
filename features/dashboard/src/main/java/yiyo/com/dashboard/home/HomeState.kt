package yiyo.com.dashboard.home

import androidx.paging.PagedList
import com.airbnb.mvrx.MvRxState
import yiyo.com.dashboard.data.models.UnsplashPhoto

data class HomeState(val photos: PagedList<UnsplashPhoto>? = null) : MvRxState