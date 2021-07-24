package com.konovus.unsplashapir.di

import android.app.Application
import androidx.room.Room
import com.konovus.unsplashapir.api.UnsplashApi
import com.konovus.unsplashapir.data.PhotosDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(UnsplashApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideUnsplashApi(retrofit: Retrofit): UnsplashApi =
        retrofit.create(UnsplashApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): PhotosDatabase =
        Room.databaseBuilder(app, PhotosDatabase::class.java, "photos_db")
            .build()
}