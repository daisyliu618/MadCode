plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
    // Android gradle plugin will allow us to access Android specific features
    implementation("com.android.tools.build:gradle:7.0.2")
}


gradlePlugin {
    plugins {
        create("GradleCommonConfigPlugin") {
            id = "com.hequanli.GradleCommonConfig"
            implementationClass = "GradleCommonConfigPlugin"
        }
    }
}