package com.android_application_architecture.android_architecture_patterns.core.analytics.di

import com.android_application_architecture.android_architecture_patterns.core.analytics.AnalyticsHelper
import com.android_application_architecture.android_architecture_patterns.core.analytics.StubAnalyticsHelper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class AnalyticsModule {
    @Binds
    abstract fun bindsAnalyticsHelper(analyticsHelperImpl: StubAnalyticsHelper): AnalyticsHelper
}
