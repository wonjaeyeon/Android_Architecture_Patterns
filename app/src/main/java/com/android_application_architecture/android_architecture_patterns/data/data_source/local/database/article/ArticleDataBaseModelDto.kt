package com.android_application_architecture.android_architecture_patterns.data.data_source.local.database.article

import com.android_application_architecture.android_architecture_patterns.data.model.article.Article
import java.util.*

// Extension function to convert ArticleDataBaseModel to Article
fun ArticleDataBaseModel.toArticle(): Article {
    return Article(
        id = this.id,
        title = this.title,
        content = this.content,
        publicationDate = this.publicationDate,
        authorName = this.authorName,
        readTimeMin = this.readTimeMin
    ).apply {
        uid = this@toArticle.uid
    }
}

// Extension function to convert Article to ArticleDataBaseModel
fun Article.toArticleDataBaseModel(authorId: Long, authorDateOfBirth: String): ArticleDataBaseModel {
    return ArticleDataBaseModel(
        id = this.id,
        title = this.title,
        content = this.content,
        publicationDate = this.publicationDate,
        authorId = authorId,
        authorName = this.authorName,
        authorDateOfBirth = authorDateOfBirth,
        readTimeMin = this.readTimeMin
    ).apply {
        uid = this@toArticleDataBaseModel.uid
    }
}