plugins {
    kotlin("multiplatform") version "1.6.10"
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.serialization") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
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
    js("frontend", IR) {
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
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val backendMain by getting {
            dependencies {
                implementation("org.springframework.boot:spring-boot-starter-web")
                implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
                implementation("org.jetbrains.kotlin:kotlin-reflect")
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
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
                implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.1-pre.240-kotlin-1.5.30")
            }
        }
        val frontendTest by getting
    }
}

tasks.named<Copy>("backendProcessResources") {
    val frontendBrowserDistribution = tasks.named("frontendBrowserDistribution")
    from(frontendBrowserDistribution)
}