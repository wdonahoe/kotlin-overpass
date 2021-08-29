plugins {
    kotlin("jvm") version "1.5.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.locationtech.jts:jts-core:1.18.0")

    testImplementation("junit:junit:4.13")
}

tasks.test {
    useJUnit()

    maxHeapSize = "1G"
}
