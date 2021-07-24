package com.konovus.unsplashapir.api

import com.konovus.unsplashapir.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query


interface UnsplashApi {

    companion object{
        const val BASE_URL = "https://api.unsplash.com/"
        const val ACCESS_KEY = BuildConfig.UNSPLASH_ACCESS_KEY
    }

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnsplashResponse
}