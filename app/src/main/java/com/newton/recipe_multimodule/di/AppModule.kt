package com.newton.recipe_multimodule.di

import com.newton.recipe_multimodule.navigation.NavigationSubGraphs
import com.newton.search.navigation.SearchFeatureApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationSubGraphs(searchFeatureApi: SearchFeatureApi): NavigationSubGraphs {
        return NavigationSubGraphs(searchFeatureApi)
    }
}