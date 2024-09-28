package com.android_application_architecture.android_architecture_patterns.data.article.data_source.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

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
    // 이렇게 하면 uid가 자동으로 생성됨
    // 공식 샘플에서 사용한 방법
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
