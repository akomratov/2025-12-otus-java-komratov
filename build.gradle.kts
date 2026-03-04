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
    val junit: String by project
    val assertjCore: String by project

    dependencies {
        implementation("com.google.guava:guava:$guava")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        testImplementation("org.junit.jupiter:junit-jupiter:$junit")
        testImplementation ("org.assertj:assertj-core:$assertjCore")
    }

    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.addAll(listOf("-parameters", "-Xlint:all,-serial,-processing"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging.showExceptions = true
        reports {
            junitXml.required.set(true)
            html.required.set(true)
        }
    }
}

