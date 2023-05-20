/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.multiplatform")
    id("dev.icerock.mobile.multiplatform-resources")
}

android {
    namespace = "com.icerockdev.mpp"

    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }

    defaultConfig {
        applicationId = "com.icerockdev.mpp"

        versionCode = 1
        versionName = "0.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

kotlin {
    android()
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")

    commonMainImplementation(moko.resources)
}

multiplatformResources {
    multiplatformResourcesPackage = "com.icerockdev.library"
}

afterEvaluate {
    tasks.withType<JavaCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }
}
