package yiyo.com.dashboard.home

import com.airbnb.mvrx.MvRxState
import yiyo.com.dashboard.data.models.Photo

data class HomeState(val photos: List<Photo> = emptyList()) : MvRxState