import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    java
    `maven-publish`
}

group = "com.github.forrestdp.guava.kotlin"
version = "0.0.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(kotlin("bom")))
    api("com.google.guava:guava:30.1.1-jre")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))
}

java {
    withSourcesJar()
    withJavadocJar()
}

kotlin {
    explicitApi = ExplicitApiMode.Strict
}

val compileKotlin: KotlinCompile by tasks
val compileTestKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        @Suppress("SuspiciousCollectionReassignment")
        freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "com.github.forrestdp"
            artifactId = "guava-kotlin"
            version = "0.0.2"

            pom {
                name.set("Guava Kotlin")
                description.set("Kotlin extensions for Google Guava library")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("forrestdp")
                        name.set("Egor Ponomaryov")
                        email.set("egorponomarev93@gmail.com")
                    }
                }
            }
        }
    }
}

tasks.create<Wrapper>("wrapper") {
    gradleVersion = "7.4.1"
    distributionType = Wrapper.DistributionType.ALL
}
