@file:Suppress("UnstableApiUsage")

rootProject.name = "guava-kotlin"
include("lib")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) 
    repositories {
        mavenCentral()
    }
    
    versionCatalogs {
        @Suppress("UNUSED_VARIABLE") 
        val libs by creating {
            val kotlin = version("kotlin", "1.6.20")
            val guava = version("guava", "30.1.1-jre")
            
            library("guava-core", "com.google.guava", "guava").versionRef(guava)
            library("kotlin-test", "org.jetbrains.kotlin", "kotlin-test").versionRef(kotlin)
            library("kotlin-testJunit5", "org.jetbrains.kotlin", "kotlin-test-junit5").versionRef(kotlin)
            
            plugin("kotlin", "org.jetbrains.kotlin.jvm").versionRef(kotlin)
        }
    }
}
