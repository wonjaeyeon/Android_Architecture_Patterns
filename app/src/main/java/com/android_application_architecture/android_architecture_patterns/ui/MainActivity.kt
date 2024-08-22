package com.android_application_architecture.android_architecture_patterns.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android_application_architecture.android_architecture_patterns.ui.router.MainNavigation
import com.android_application_architecture.android_architecture_patterns.ui.theme.Android_Architecture_PatternsTheme
import dagger.hilt.android.AndroidEntryPoint

// An activity is a single, focused thing that the user can do.
// Almost all activities interact with the user,
// so the Activity class takes care of creating a window for you
// in which you can place your UI with setContentView(View)
// - https://developer.android.com/reference/android/app/Activity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
                    MainNavigation()
//                    Scaffold(
//                        topBar = {
//                            Text(
//                                text = "Android Architecture Patterns",
//                                modifier = Modifier.padding(16.dp)
//                            )
//                        }
//                    ) {
//                    }
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_Architecture_PatternsTheme {
        Greeting("Android")
    }
}