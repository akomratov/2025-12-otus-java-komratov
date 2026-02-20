plugins {
    java
}

allprojects {
    group = "ru.otus"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    val guava: String by project

    dependencies {
        implementation("com.google.guava:guava:$guava")
    }

    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.addAll(listOf("-parameters", "-Xlint:all,-serial,-processing"))
    }
}

