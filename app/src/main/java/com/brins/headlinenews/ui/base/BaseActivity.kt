package com.brins.headlinenews.ui.base

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.anzewei.parallaxbacklayout.ParallaxHelper
import com.github.anzewei.parallaxbacklayout.ViewDragHelper.EDGE_LEFT
import com.github.anzewei.parallaxbacklayout.widget.ParallaxBackLayout.EDGE_MODE_DEFAULT
import com.github.anzewei.parallaxbacklayout.widget.ParallaxBackLayout.LAYOUT_COVER
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    protected var TAG = this.javaClass.simpleName

    companion object {
        private var mCurrentActivity: Activity? = null// 对所有activity进行管理
        var mActivities: MutableList<Activity> = LinkedList()
        protected var savedInstanceState: Bundle? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (enableSlideClose()) {
            val paraLayout = ParallaxHelper.getParallaxBackLayout(this, true)
            paraLayout.setEdgeMode(EDGE_MODE_DEFAULT)//边缘滑动
            paraLayout.edgeFlag = getEdgeDirection()
            paraLayout.setLayoutType(getSlideLayoutType(), null)
        }
    }

    abstract fun getLayout(): Int


    fun getSlideLayoutType(): Int {
        return LAYOUT_COVER
    }

    fun getEdgeDirection(): Int {
        return EDGE_LEFT
    }

    protected open fun enableSlideClose(): Boolean {
        return true
    }
}