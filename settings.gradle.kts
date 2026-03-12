rootProject.name = "OtusJavaPro"

include("hw01-gradle")
include("hw02-generics")

pluginManagement {

    val johnrengelmanShadow: String by settings

    plugins {
        id("com.github.johnrengelman.shadow") version johnrengelmanShadow
    }
}
