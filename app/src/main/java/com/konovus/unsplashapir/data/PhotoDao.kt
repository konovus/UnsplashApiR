package com.konovus.unsplashapir.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Query("select * from photos")
    fun getAllPhotos(): Flow<List<UnsplashPhoto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(photos: List<UnsplashPhoto>)

    @Query("delete from photos")
    suspend fun deleteAllPhotos()
}