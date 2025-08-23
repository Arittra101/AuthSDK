plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.plugin.parcelize") // ✅ Add this
}

android {
    namespace = "com.bachelors.authsdk"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    api("io.insert-koin:koin-android:3.5.3")
    api("io.insert-koin:koin-androidx-compose:3.5.3")

    // Retrofit
    api("com.squareup.retrofit2:retrofit:2.11.0")
    api("com.squareup.retrofit2:converter-gson:2.11.0")


    // OkHttp

    api("com.squareup.okhttp3:logging-interceptor:4.12.0")
    api("com.squareup.okhttp3:okhttp:4.12.0")


    // Core coroutine support
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    // Android-specific coroutine support (if your SDK runs on Android Main thread)
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")


}