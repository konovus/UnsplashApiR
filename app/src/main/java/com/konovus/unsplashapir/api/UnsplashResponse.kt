package com.konovus.unsplashapir.api

import com.konovus.unsplashapir.data.UnsplashPhoto


data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)