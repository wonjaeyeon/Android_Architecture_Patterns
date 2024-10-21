@Suppress("DSL_SCOPE_VIOLATION") // Remove when fixed https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    // compose
    alias(libs.plugins.compose.compiler)

    // hilt
    alias(libs.plugins.hilt.gradle)

    // kapt
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)

    // ksp
    alias(libs.plugins.ksp)

    // protobuf
    alias(libs.plugins.protobuf)
}

android {
    namespace = "com.android_application_architecture.android_architecture_patterns"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android_application_architecture.android_architecture_patterns"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8 // for example ) hilt uses java 8 features
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    sourceSets {
        getByName("main") {
            java {
                srcDirs("build/generated/source/proto/main/java")
                srcDirs("build/generated/source/proto/main/kotlin") // If you are generating Kotlin files
            }
        }
    }

}


// Setup protobuf configuration, generating lite Java and Kotlin classes
protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                register("java") {
                    option("lite")
                }
                register("kotlin") {
                    option("lite")
                }
            }
        }
    }
}


// Declaring dependencies in Gradle involves specifying libraries or
// files that your project depends on.
// ref - https://docs.gradle.org/current/userguide/declaring_dependencies.html
dependencies {

    // DEFAULT DEPENDENCIES
    // MAIN
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    // Compose UI
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    // Compose UI Test
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))

    // Compose UI Test JUnit4`
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)


    // ADDED DEPENDENCIES

    // Google Accompanist
    implementation(libs.accompanist.adaptive)

    // Compose Material3
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material3.adaptive.navigationSuite)
    implementation(libs.androidx.compose.materialWindow)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // window
    implementation(libs.androidx.window)
    implementation(libs.androidx.window.core)

    // AndroidX work
    implementation(libs.androidx.work.ktx)
    testImplementation(libs.androidx.work.testing)

    // AndroidX data store
    implementation(libs.androidx.dataStore)

    // Dagger-Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)

    kapt(libs.hilt.compiler)
    // Hilt and instrumented tests.
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)
    // Hilt and Robolectric tests.
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.android.compiler)
    // Hilt Ext
    implementation(libs.hilt.ext.compiler)
    implementation(libs.hilt.ext.work)

    // Room DB
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.room.compiler)

    // Room DB Optional
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.rxjava2)
    implementation(libs.androidx.room.rxjava3)
    implementation(libs.androidx.room.guava)
    testImplementation(libs.androidx.room.testing)
    implementation(libs.androidx.room.paging)


    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.guava)

    // kotlinx serialization
    implementation(libs.kotlinx.serialization.json)

    // kotlinx datetime
    implementation(libs.kotlinx.datetime)

    // coil
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.coil.kt.svg)

    // profileinstaller
    implementation(libs.androidx.profileinstaller)

    // protobuf
    implementation(libs.protobuf.protoc)
    implementation(libs.protobuf.kotlin.lite)
    //implementation(libs.protobuf.java.lite)

    // Local tests: jUnit, coroutines, Android runner
    // JUnit is already added by default
    testImplementation(libs.kotlinx.coroutines.test)

    // Instrumented tests: jUnit rules and runners
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.runner)


}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}