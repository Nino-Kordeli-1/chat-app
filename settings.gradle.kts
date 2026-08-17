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

fun Settings.includeAllModules(directoryName: String) {
    file(directoryName)
        .listFiles()
        ?.filter { file ->
            file.isDirectory &&
                    file.name != "build" &&
                    !file.name.startsWith(".") &&
                    file.resolve("build.gradle.kts").exists()
        }
        ?.forEach { moduleDir ->
            include(":$directoryName:${moduleDir.name}")
        }
}
rootProject.name = "ChatApp"
include(":app")
includeAllModules("core")