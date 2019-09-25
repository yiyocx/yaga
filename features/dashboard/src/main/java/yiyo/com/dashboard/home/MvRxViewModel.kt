package yiyo.com.dashboard.home

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import yiyo.com.dashboard.BuildConfig

abstract class MvRxViewModel<S : MvRxState>(initialState: S) : BaseMvRxViewModel<S>(
    initialState,
    debugMode = BuildConfig.DEBUG
)