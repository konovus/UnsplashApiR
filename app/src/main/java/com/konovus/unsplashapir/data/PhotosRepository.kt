package com.konovus.unsplashapir.data

import androidx.room.withTransaction
import com.konovus.unsplashapir.api.UnsplashApi
import com.konovus.unsplashapir.cache.networkBoundResource
import javax.inject.Inject

class PhotosRepository @Inject constructor(
    private val api: UnsplashApi,
    private val db: PhotosDatabase
) {

    private val photosDao = db.photoDao()

    fun getPhotos(query: String, page: Int, perPage: Int) = networkBoundResource(
        query = {
            photosDao.getAllPhotos()
        },
        fetch = {
            api.searchPhotos(query, page, perPage)
        },
        saveFetchResult = { response ->
            db.withTransaction {
                photosDao.deleteAllPhotos()
                photosDao.insertPhotos(response.results)
            }
        }
    )
}