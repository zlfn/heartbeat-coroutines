repositories {
    mavenLocal()
}

val projectCore = project(":${rootProject.name}")

dependencies {
    implementation(projectCore)
}

val pluginName = rootProject.name.split('-').joinToString("") { it.capitalize() }
val packageName = rootProject.name.replace("-", ".")
extra.set("pluginName", pluginName)
extra.set("packageName", packageName)

tasks {
    processResources {
        filesMatching("*.yml") {
            expand(project.properties)
            expand(extra.properties)
        }
    }

    create<Jar>("paperJar") {
        dependsOn(projectCore.tasks.named("publishAllPublicationsToDebugRepository"))

        archiveBaseName.set(pluginName)
        archiveVersion.set("")

        from(project.sourceSets["main"].output)

        doLast {
            copy {
                from(archiveFile)
                val plugins = File(rootDir, ".debug/plugins/")
                into(if (File(plugins, archiveFileName.get()).exists()) File(plugins, "update") else plugins)
            }
        }
    }
}
