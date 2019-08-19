package com.brins.headlinenews

import android.app.Application
import com.github.anzewei.parallaxbacklayout.ParallaxHelper

class HeadlineApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(ParallaxHelper.getInstance())

    }
}