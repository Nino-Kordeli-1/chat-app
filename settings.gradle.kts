enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    includeBuild("build-logic")

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
    }
}

fun Settings.includeAllModules(directoryPath: String) {
    file(directoryPath)
        .listFiles()
        ?.filter { file ->
            file.isDirectory &&
                    file.name != "build" &&
                    !file.name.startsWith(".")
        }
        ?.forEach { moduleDir ->
            val childPath = "$directoryPath/${moduleDir.name}"

            if (moduleDir.resolve("build.gradle.kts").exists()) {
                val gradlePath = ":" + childPath.replace("/", ":")
                include(gradlePath)
            }
            includeAllModules(childPath)
        }
}

rootProject.name = "ChatApp"
include(":app")
includeAllModules("core")
includeAllModules("feature")