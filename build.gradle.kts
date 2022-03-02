plugins {
    kotlin("multiplatform") version "1.6.10"
    application
    kotlin("plugin.serialization") version "1.6.10"
}
group = "nl.kvns"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
    maven {
        url = uri("https://kotlin.bintray.com/kotlinx")
    }
}

kotlin {
    jvm("backend") {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
        withJava()
    }
    js("frontend", LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
                val map = mutableMapOf<String, Any>()
                map["/api"] = "http://localhost:3000"
                devServer?.proxy = map
            }
        }
    }
    sourceSets {
        val serializationVersion = "0.13.0"
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
                implementation(kotlin("test"))
            }
        }
        val backendMain by getting {
            dependencies {
                implementation("io.ktor:ktor-server-netty:1.6.3")
                implementation("io.ktor:ktor-html-builder:1.6.3")
                implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
                implementation("com.google.code.gson:gson:2.7")
            }
        }
        val backendTest by getting
        val frontendMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.240-kotlin-1.5.30")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.240-kotlin-1.5.30")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:5.2.0-pre.240-kotlin-1.5.30")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-redux:4.1.0-pre.240-kotlin-1.5.30")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux:7.2.4-pre.240-kotlin-1.5.30")
                implementation("org.reduxkotlin:redux-kotlin-thunk:0.5.3")
                implementation("org.slf4j:slf4j-api:1.7.5")
                implementation("org.slf4j:slf4j-log4j12:1.7.5")
                implementation("org.slf4j:slf4j-jdk14:1.7.5")
                implementation("com.google.code.gson:gson:2.7")
            }
        }
        val frontendTest by getting
    }
}

application {
    mainClass.set("ServerKt")
}

tasks.named<Copy>("backendProcessResources") {
    val frontendBrowserDistribution = tasks.named("frontendBrowserDistribution")
    from(frontendBrowserDistribution)
}

tasks.named<JavaExec>("run") {
    dependsOn(tasks.named<Jar>("backendJar"))
    classpath(tasks.named<Jar>("backendJar"))
}