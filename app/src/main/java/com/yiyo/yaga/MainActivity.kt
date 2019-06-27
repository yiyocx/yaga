package com.yiyo.yaga

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import yiyo.com.actions.Actions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Actions.openLoginIntent(this))
        finish()
    }
}
