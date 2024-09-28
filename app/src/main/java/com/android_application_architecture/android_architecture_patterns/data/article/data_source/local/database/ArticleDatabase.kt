package com.android_application_architecture.android_architecture_patterns.data.article.data_source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

// The following code defines an ArticleDatabase class to hold the database.
// ArticleDatabase defines the database configuration and serves as the app's main access point to the persisted data.
// The database class must satisfy the following conditions:
// ref - https://developer.android.com/training/data-storage/room#kts


@Database(entities = [ArticleDataBaseModel::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleDataBaseModelDao(): ArticleDataBaseModelDao
}

