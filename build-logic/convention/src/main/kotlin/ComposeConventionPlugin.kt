import ConventionConstants.Plugins
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(Plugins.KOTLIN_COMPOSE)

            pluginManager.withPlugin(Plugins.ANDROID_APPLICATION) {
                extensions.configure<ApplicationExtension> {
                    buildFeatures.compose = true
                }
            }
            pluginManager.withPlugin(Plugins.ANDROID_LIBRARY) {
                extensions.configure<LibraryExtension> {
                    buildFeatures.compose = true
                }
            }

            configureComposeDependencies()
        }
    }
}