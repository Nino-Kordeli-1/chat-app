import ConventionConstants.Libraries
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun Project.configureAndroidApplication(extension: ApplicationExtension) {
    pluginManager.apply(ConventionConstants.Plugins.KOTLIN_SERIALIZATION)

    extension.apply {
        compileSdk = ConventionConstants.COMPILE_SDK
        defaultConfig {
            minSdk = ConventionConstants.MIN_SDK
            targetSdk = ConventionConstants.TARGET_SDK
        }
        compileOptions {
            sourceCompatibility = ConventionConstants.JAVA_VERSION
            targetCompatibility = ConventionConstants.JAVA_VERSION
        }
    }
    configureSharedKotlinAndDependencies()
}

internal fun Project.configureAndroidLibrary(extension: LibraryExtension) {
    pluginManager.apply(ConventionConstants.Plugins.KOTLIN_SERIALIZATION)

    extension.apply {
        compileSdk = ConventionConstants.COMPILE_SDK
        defaultConfig {
            minSdk = ConventionConstants.MIN_SDK
        }
        compileOptions {
            sourceCompatibility = ConventionConstants.JAVA_VERSION
            targetCompatibility = ConventionConstants.JAVA_VERSION
        }
    }
    configureSharedKotlinAndDependencies()
}

private fun Project.configureSharedKotlinAndDependencies() {
    extensions.configure<KotlinAndroidProjectExtension> {
        compilerOptions {
            jvmTarget.set(ConventionConstants.JVM_TARGET)
        }
    }

    dependencies {
        implementation(libs, Libraries.ANDROIDX_CORE_KTX)
        implementation(libs, Libraries.ANDROIDX_LIFECYCLE_RUNTIME)
        implementation(libs, Libraries.KOIN_ANDROID)
        implementationBundle(libs, ConventionConstants.Bundles.NAVIGATION)
        testImplementationBundle(libs, ConventionConstants.Bundles.TESTING)
    }
}

internal fun Project.configureComposeDependencies() {
    dependencies {
        implementationPlatform(libs, Libraries.COMPOSE_BOM)
        implementationBundle(libs, ConventionConstants.Bundles.COMPOSE)
        implementation(libs, Libraries.KOIN_COMPOSE)
        implementation(libs, Libraries.ANDROIDX_ACTIVITY_COMPOSE)
        debugImplementationBundle(libs, ConventionConstants.Bundles.COMPOSE_DEBUG)
    }
}

internal fun Project.configureStorageDependencies() {
    pluginManager.apply(ConventionConstants.Plugins.KSP)

    dependencies {
        implementation(libs, Libraries.ROOM_RUNTIME)
        implementation(libs, Libraries.ROOM_KTX)
        ksp(libs, Libraries.ROOM_COMPILER)
    }
}