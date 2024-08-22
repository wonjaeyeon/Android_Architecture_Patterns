plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")

    alias(libs.plugins.compose.compiler)

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
}

// Declaring dependencies in Gradle involves specifying libraries or
// files that your project depends on.
// ref - https://docs.gradle.org/current/userguide/declaring_dependencies.html
dependencies {

    implementation(libs.androidx.lifecycle.runtime.compose.android)
    implementation(libs.androidx.navigation.compose)
    // implementation - This configuration is used to declare dependencies that are used in the implementation of your project.
    // ref - https://docs.gradle.org/current/userguide/dependency_management.html#sub:configurations
    // testImplementation - This configuration is used to declare dependencies that are used for compiling and running tests.
    // ref - https://docs.gradle.org/current/userguide/dependency_management.html#sub:configurations
    // androidTestImplementation - This configuration is used to declare dependencies that are used only for Android instrumentation tests, which run on an Android device.
    // ref - https://docs.gradle.org/current/userguide/dependency_management.html#sub:configurations
    // debugImplementation - This configuration is used to declare dependencies that are used only for debug builds.
    // ref - https://docs.gradle.org/current/userguide/dependency_management.html#sub:configurations
    // kapt - This configuration is used to declare dependencies that are used for annotation processing.
    // ref - https://docs.gradle.org/current/userguide/dependency_management.html#sub:configurations
    // ksp - This configuration is used to declare dependencies that are used for Kotlin Symbol Processing (KSP).
    // ref - https://docs.gradle.org/current/userguide/dependency_management.html#sub:configurations
    // platform - This configuration is used to declare dependencies that are used to define the versions of other dependencies.
    // ref - https://docs.gradle.org/current/userguide/dependency_management.html#sub:configurations


    // Specify the Compose BOM with a version definition
    // making every library's version is up-to-date into stable working well version
    // ref - https://developer.android.com/develop/ui/compose/bom
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Core Android dependencies
    // Android KTX is a set of Kotlin extensions that are included with Android Jetpack and other Android libraries. KTX extensions provide concise, idiomatic Kotlin to Jetpack, Android platform, and other APIs.
    // ref - https://developer.android.com/kotlin/ktx
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Hilt
    implementation(libs.hilt.android)
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    kapt(libs.hilt.android.compiler)
    kapt(libs.hilt.compiler)
    testImplementation(libs.hilt.android.testing)


    // Room
    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
    // To use Kotlin Symbol Processing (KSP)
    // ksp("androidx.room:room-compiler:$room_version") // ksp가 되게 만들어야 함. kotlin 2.0.0 이상

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    // optional - RxJava2 support for Room
    implementation("androidx.room:room-rxjava2:$room_version")

    // optional - RxJava3 support for Room
    implementation("androidx.room:room-rxjava3:$room_version")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation("androidx.room:room-guava:$room_version")

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:$room_version")

    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:$room_version")


    // Compose UI
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)


    testImplementation(libs.junit)


    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)


    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}