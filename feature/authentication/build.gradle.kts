plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    namespace = "com.chatapp.feature.auth"
}

dependencies {
    implementation(projects.core.navigation)
}