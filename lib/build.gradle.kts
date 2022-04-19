import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.kotlin)
    java
    `maven-publish`
}

group = "com.github.forrestdp.guava.kotlin"
version = "0.0.3"

dependencies {
    api(libs.guava.core)

    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotlin.testJunit5)
}

java {
    withSourcesJar()
    withJavadocJar()
}

kotlin {
    explicitApi()
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            pom.name.set("Guava Kotlin")
//            pom {
//                name.set("Guava Kotlin")
//                description.set("Kotlin extensions for Google Guava library")
//
//                licenses {
//                    license {
//                        name.set("The Apache License, Version 2.0")
//                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//
//                developers {
//                    developer {
//                        id.set("forrestdp")
//                        name.set("Egor Ponomaryov")
//                        email.set("egorponomarev93@gmail.com")
//                    }
//                }
//            }
        }
    }
}

tasks.create<Wrapper>("wrapper") {
    gradleVersion = "7.4.2"
    distributionType = Wrapper.DistributionType.ALL
}
