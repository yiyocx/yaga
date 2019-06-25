package yiyo.com.actions

import android.content.Context
import android.content.Intent

object Actions {
    fun openLoginIntent(context: Context): Intent = internalIntent(context, "com.yiyo.yaga.login.open")

    fun openDashboardIntent(context: Context): Intent = internalIntent(context, "com.yiyo.yaga.dashboard.open")

    private fun internalIntent(context: Context, action: String) = Intent(action).setPackage(context.packageName)
}