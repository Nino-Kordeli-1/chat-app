plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    namespace = "com.chatapp.data"
}

dependencies{
    implementation(projects.core.domain)
}