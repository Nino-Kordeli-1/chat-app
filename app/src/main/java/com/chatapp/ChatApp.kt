package com.chatapp

import android.app.Application
import com.chatapp.data.di.coreDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChatApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ChatApp)
            modules(
                coreDataModule
            )
        }
    }
}