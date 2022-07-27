package com.example.dictionary

import android.app.Application
import com.example.dictionary.di.InjectionModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
class DictionaryApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DictionaryApp)
            modules(InjectionModules.getModules())
        }
    }
}