package com.android_application_architecture.android_architecture_patterns.data.data_source.local.database.article

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// Data Access Object for MyModel
@Dao
interface ArticleDataBaseModelDao {
    @Query("SELECT * FROM articleDataBaseModel ORDER BY uid DESC")
    fun getArticleDataBaseModels(): Flow<List<ArticleDataBaseModel>>

    @Query("SELECT * FROM articleDataBaseModel WHERE uid = :uid")
    fun getArticleDataBaseModel(uid: Int): Flow<ArticleDataBaseModel>

    @Insert
    suspend fun insertArticleDataBaseModel(item: ArticleDataBaseModel)

    @Query("DELETE FROM articleDataBaseModel WHERE uid = :uid")
    suspend fun deleteArticleDataBaseModel(uid: Int)
}
