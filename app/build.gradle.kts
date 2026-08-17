plugins {
    alias(libs.plugins.convention.android.application)
}

android {
    namespace = "com.chatapp"
}

dependencies{
    implementation(projects.core.designsystem)
}

dependencies {
    implementation(project(":core:navigation"))
}