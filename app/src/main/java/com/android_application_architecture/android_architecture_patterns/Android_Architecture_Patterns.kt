package com.android_application_architecture.android_architecture_patterns

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.android_application_architecture.android_architecture_patterns.ui.util.ProfileVerifierLogger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

//
 @HiltAndroidApp
 class Android_Architecture_Patterns : Application(), ImageLoaderFactory {
  @Inject
    lateinit var imageLoader: dagger.Lazy<ImageLoader>

    @Inject
    lateinit var profileVerifierLogger : ProfileVerifierLogger

    override fun onCreate() {
        super.onCreate()
        Sync.initialize(context = this)
        profileVerifierLogger()
    }

    override fun newImageLoader(): ImageLoader = imageLoader.get()

 }
