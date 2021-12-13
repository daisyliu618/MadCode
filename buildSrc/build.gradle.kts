plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("com.android.tools.build:gradle:7.0.3")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
}

gradlePlugin {
    plugins {
        create("GradleCommonConfigPlugin") {
            id = "com.hequanli.GradleCommonConfig"
            implementationClass = "GradleCommonConfigPlugin"
        }
    }
}