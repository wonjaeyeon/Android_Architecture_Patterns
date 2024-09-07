package com.android_application_architecture.android_architecture_patterns.data.data_source.local.database.article

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

// Entity -> Model class for Room Database
@Entity
data class ArticleDataBaseModel(
    val id : Long,
    val title : String,
    val content : String,
    // modify publicationDate to string
    val publicationDate : String,
    val authorId : Long,
    val authorName : String,
    val authorDateOfBirth : String,
    val readTimeMin : Int
    ) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
