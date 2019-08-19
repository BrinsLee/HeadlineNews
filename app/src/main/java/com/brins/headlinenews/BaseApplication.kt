package com.brins.headlinenews

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

open class BaseApplication : MultiDexApplication() {

    companion object {

        private lateinit var mContext: Context
        private lateinit var mMainThread : Thread
        private var mMainThreadId: Long = 0//主线程id
        private var mMainLooper: Looper? = null//循环队列
        private var mHandler: Handler? = null//主线程Handler

        @JvmStatic
        fun getContext() : Context{
            return mContext
        }

        @JvmStatic
        fun setContext(context: Context){
            mContext = context
        }

        fun getMainThread(): Thread {
            return mMainThread
        }

        fun setMainThread(mMainThread: Thread) {
            this.mMainThread = mMainThread
        }

        fun getMainThreadId(): Long {
            return mMainThreadId
        }

        fun setMainThreadId(mMainThreadId: Long) {
            this.mMainThreadId = mMainThreadId
        }

        fun getMainThreadLooper(): Looper ?{
            return mMainLooper
        }

        fun setMainThreadLooper(mMainLooper: Looper) {
            this.mMainLooper = mMainLooper
        }

        fun getMainHandler(): Handler? {
            return mHandler
        }

        fun setMainHandler(mHandler: Handler) {
            this.mHandler = mHandler
        }
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
        mMainThread = Thread.currentThread()
        mMainThreadId = mMainThread.id
        mHandler = Handler()
    }


}