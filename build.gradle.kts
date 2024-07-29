// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    // Adding the Google services plugin for Firebase
    id ("com.google.gms.google-services") version "4.3.13" apply false
}

buildscript {
    dependencies {
        // Classpath for Google services
        classpath("com.google.gms:google-services:4.3.10")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
