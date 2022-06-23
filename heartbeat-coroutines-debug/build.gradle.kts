val projectCore = project(":${rootProject.name}")

dependencies {
    implementation(projectCore)
}

val pluginName = rootProject.name.split('-').joinToString("") { it.capitalize() }

extra.apply {
    set("pluginName", pluginName)

    set("kotlinVersion", Dependency.Kotlin.Version)
    set("coroutinesVersion", Dependency.Coroutines.Version)
}

tasks {
    // generate plugin.yml
    processResources {
        filesMatching("*.yml") {
            expand(project.properties)
            expand(extra.properties)
        }
    }

    register<Copy>("paperJar") {
        dependsOn(projectCore.tasks.named("publishAllPublicationsToDebugRepository"))
        from(jar)

        val jarName = "$pluginName.jar"
        rename { jarName }
        val plugins = File("../.debug-server/plugins")
        val plugin = File(plugins, "$pluginName.jar")

        if (plugin.exists())    into(File(plugins, "update"))
        else                    into(plugins)
    }
}
