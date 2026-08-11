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

fun Settings.includeAllModules(directory: String) {
    file(directory)
        .listFiles()
        ?.filter { it.isDirectory }
        ?.forEach { module ->
            include(":$directory:${module.name}")
        }
}
rootProject.name = "ChatApp"
include(":app")
includeAllModules("core")