plugins {
    alias(libs.plugins.convention.android.application)
    alias(libs.plugins.convention.compose)
}

android {
    namespace = "com.chatapp"

    defaultConfig {
        applicationId = "com.chatapp"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
}