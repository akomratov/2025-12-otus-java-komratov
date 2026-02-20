plugins {
    id("java")
    id("com.github.johnrengelman.shadow")
}

group = "ru.otus"
version = "0.1"

dependencies {
    implementation("com.google.guava:guava")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "ru.otus.hw01.HelloOtus"
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
