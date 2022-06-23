plugins {
    kotlin("jvm") version Dependency.Kotlin.Version
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        maven("https://papermc.io/repo/repository/maven-public/")
    }

    dependencies {
        compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")

        api(kotlin("stdlib"))
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Dependency.Coroutines.Version}")
    }
}
