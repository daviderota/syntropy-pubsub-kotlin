plugins {
    id("java")
    kotlin("jvm") version "1.9.20-Beta"
}

group = "syntropy.pubsub"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.nats:jnats:2.16.14")
    implementation("net.i2p.crypto:eddsa:0.3.0")
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(18)
}