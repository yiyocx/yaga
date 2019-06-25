package com.yiyo.yaga.di

import yiyo.com.common.di.networkModule
import yiyo.com.dashboard.di.dashboardModule

val appComponent = listOf(networkModule, dashboardModule)