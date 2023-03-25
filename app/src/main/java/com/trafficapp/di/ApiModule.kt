package com.trafficapp.di

import com.trafficapp.api.TrafficApi
import com.trafficapp.core.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_API_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
        return retrofitBuilder.build()
    }

    @Singleton
    @Provides
    fun provideTrafficApi(retrofit: Retrofit): TrafficApi = retrofit.create(TrafficApi::class.java)
}