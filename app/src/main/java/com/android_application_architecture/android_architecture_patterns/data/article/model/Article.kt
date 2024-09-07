package com.android_application_architecture.android_architecture_patterns.data.article.model

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