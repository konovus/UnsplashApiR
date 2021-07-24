package com.konovus.unsplashapir.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UnsplashPhoto::class], version = 1, exportSchema = false)
abstract class PhotosDatabase : RoomDatabase(){

    abstract fun photoDao(): PhotoDao
}