android {
    defaultConfig {
        multiDexEnabled = true
    }
}

dependencies {
    implementation(Libs.kotlin_stdlib)
    implementation(Libs.core_ktx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    implementation(Libs.constraint_layout)
    implementation("androidx.multidex:multidex:2.0.1")
    api(project(mapOf("path" to ":base:base_repository")))
}