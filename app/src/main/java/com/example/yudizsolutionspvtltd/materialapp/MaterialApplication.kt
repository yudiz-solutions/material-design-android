package com.example.yudizsolutionspvtltd.materialapp

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class MaterialApplication : Application() {
    companion object {
        lateinit var instance: MaterialApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

}