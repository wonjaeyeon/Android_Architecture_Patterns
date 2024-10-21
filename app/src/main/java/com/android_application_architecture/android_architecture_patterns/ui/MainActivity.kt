package com.android_application_architecture.android_architecture_patterns.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android_application_architecture.android_architecture_patterns.ui.feature.reply.ReplyHomeViewModel
import com.android_application_architecture.android_architecture_patterns.ui.theme.Android_Architecture_PatternsTheme
import com.google.accompanist.adaptive.calculateDisplayFeatures
import dagger.hilt.android.AndroidEntryPoint

// An activity is a single, focused thing that the user can do.
// Almost all activities interact with the user,
// so the Activity class takes care of creating a window for you
// in which you can place your UI with setContentView(View)
// - https://developer.android.com/reference/android/app/Activity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        // here you initialize your activity.
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Android_Architecture_PatternsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MainNavigation()
//                    Scaffold(
//                        topBar = {
//                            Text(
//                                text = "Android Architecture Patterns",
//                                modifier = Modifier.padding(16.dp)
//                            )
//                        }
//                    ) {
//                    }
                    val windowSize = calculateWindowSizeClass(this)
                    val displayFeatures = calculateDisplayFeatures(this)
                    //val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                    ReplyApp(
                        windowSize = windowSize,
                        displayFeatures = displayFeatures,
                    )
                }
            }
        }

        super.onStart() // after the onCreate() method

        super.onRestart() // user navigates to the activity

        super.onResume() // after the onStart() method, user returns to the activity

        super.onPause() // another activity comes into the foreground

        super.onStop() // the activity is no longer visible

        super.onDestroy() // the activity is finishing or being destroyed by the system
    }
}
