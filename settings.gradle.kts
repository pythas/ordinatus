pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "ordinatus"
include(":task-service")
include(":ai-service")
include("libs")