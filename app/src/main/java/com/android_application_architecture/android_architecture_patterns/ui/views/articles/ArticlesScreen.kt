package com.android_application_architecture.android_architecture_patterns.ui.views.articles

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android_application_architecture.android_architecture_patterns.ui.view_models.articles.ArticleUiState
import com.android_application_architecture.android_architecture_patterns.ui.view_models.articles.ArticleViewModel
import java.util.*
import kotlin.reflect.KFunction4
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel // need implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ArticlesScreen(
    modifier: Modifier,
    viewModel: ArticleViewModel = hiltViewModel()
) {

    val items by viewModel.uiState.collectAsStateWithLifecycle()
    if (items is ArticleUiState.Success) {


        ArticlesScreen(
            items = (items as ArticleUiState.Success).articles,
            onSave = viewModel::addArticle,
            modifier = modifier
        )
    }

}

@Composable
internal fun ArticlesScreen(
    items: List<String>,
    onSave: KFunction4<Article, String, Long, String, Unit>,
    modifier: Modifier = Modifier
) {


    Column(modifier) {
        var nameArticle by remember { mutableStateOf("Compose") }
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = nameArticle,
                onValueChange = { nameArticle = it }
            )

            Button(modifier = Modifier.width(96.dp), onClick = {
                val article = Article(
                    id = Date().time.toLong(),
                    title = nameArticle,
                    content = "Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                    publicationDate = Date().time.toString(),
                    authorName = "Android Developers",
                    readTimeMin = 5
                )

                onSave(article, "ss", 1, "ss")

            }) {
                Text("Save")
            }
        }
        items.forEach {
            Text(text = it)
        }
    }
}