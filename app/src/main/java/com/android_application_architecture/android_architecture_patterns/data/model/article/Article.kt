package com.android_application_architecture.android_architecture_patterns.data.model.article

import androidx.room.PrimaryKey
import com.android_application_architecture.android_architecture_patterns.data.data_source.local.database.article.ArticleDataBaseModel
import java.util.*

data class Article(
    val id : Long,
    val title : String,
    val content : String,
    val publicationDate : String,
    val authorName : String,
    val readTimeMin : Int
){
    var uid: Int = 0;
}