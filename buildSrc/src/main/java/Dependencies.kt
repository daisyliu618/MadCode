/**
 * @author HQL
 * Created on 2021/5/11
 * Desc:
 * 版本依赖查询：
 * google: https://developer.android.google.cn/jetpack/androidx/versions
 * maven:https://mvnrepository.com/
 *
 */

object Versions {

    const val applicationId = "com.hequanli.madcode"

    const val compileSdkVersion = 31
    const val minSdkVersion = 21
    const val targetSdkVersion = 31
    const val versionCode = 1
    const val versionName = "1.0"

    const val gradle_version = "7.0.2"
    const val appcompat_version = "1.4.0"
    const val kotlin_version = "1.6.0"
    const val kotlin_coroutines_version = "1.6.0-RC"
    const val core_ktx_version = "1.3.2"
    const val material_version = "1.4.0"
    const val constraint_layout_version = "2.0.1"

    const val okhttp_version = "4.9.2"
    const val retrofit_version = "2.9.0"
    const val gson_version = "2.8.9"

    const val logan_version = "1.2.4"

    const val rxjava3_version = "3.1.2"
    const val rxjava_adapter_version = "2.9.0"
    const val rxandroid_version = "3.0.0"
    const val livedata_version = "2.4.0"
    const val viewmodel_version = "2.4.0"

    const val annotation_version = "1.3.0"
}

object Libs {
    //Kotlin
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
    const val kotlin_coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin_coroutines_version}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx_version}"

    //RxXXX
    const val rxjava3 = "io.reactivex.rxjava3:rxjava:${Versions.rxjava3_version}"
    const val rxjava_adapter =
        "com.squareup.retrofit2:adapter-rxjava3:${Versions.rxjava_adapter_version}"
    const val rxandroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxandroid_version}"

    //UI
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
    const val material = "com.google.android.material:material:${Versions.material_version}"
    const val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"

    //HTTP
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val gson = "com.google.code.gson:gson:${Versions.gson_version}"

    //log日志库, https://github.com/Meituan-Dianping/Logan 前后台完整的解决方案
    const val logan = "com.dianping.android.sdk:logan:${Versions.logan_version}"

    //JetPack
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedata_version}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel_version}"

    const val annotation ="androidx.annotation:annotation:${Versions.annotation_version}"
}