import Testing.androidTestImplementation
import Testing.testImplementation
import com.android.build.gradle.*
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.PluginContainer
import org.gradle.kotlin.dsl.getByType

/**
 * @author HQL
 * Created on 2021/12/7
 * Desc: gradle公共配置插件
 */

class GradleCommonConfigPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.config(project)
    }

    private fun PluginContainer.config(project: Project) {
        whenPluginAdded {
            when (this) {
                //com.android.application
                is AppPlugin -> {
                    //公共插件
                    project.configCommonPlugin()
                    //公共 android 配置项
                    project.extensions.getByType<AppExtension>().applyAppCommons(project)
                    //公共依赖
                    project.configAppDependencies()
                }
                //com.android.library
                is LibraryPlugin -> {
                    //公共插件
                    project.configCommonPlugin()
                    //公共 android 配置项
                    project.extensions.getByType<LibraryExtension>().applyLibraryCommons(project)
                    //公共依赖
                    project.configLibraryDependencies()
                }
            }
        }
    }

    /**
     * library Module 公共依赖
     */
    private fun Project.configLibraryDependencies() {
        dependencies.apply {
            add(api, fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
            configTestDependencies()
        }
    }

    /**
     * app Module 公共依赖
     */
    private fun Project.configAppDependencies() {
        dependencies.apply {
            add(implementation, fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
            configTestDependencies()
        }
    }

    /**
     * test 依赖配置
     */
    private fun DependencyHandler.configTestDependencies() {
        testImplementation(Testing.testLibraries)
        androidTestImplementation(Testing.androidTestLibraries)
    }

    /**
     * kotlin 插件
     */
    private fun Project.configCommonPlugin() {
        plugins.apply("kotlin-android")
        plugins.apply("kotlin-parcelize")
    }

    /**
     * app Module 配置项，此处固定了 applicationId
     */
    private fun AppExtension.applyAppCommons(project: Project) {
        defaultConfig { applicationId = BuildConfig.applicationId }
        applyBaseCommons(project)
    }

    /**
     * library Module 配置项
     */
    private fun LibraryExtension.applyLibraryCommons(project: Project) {
        applyBaseCommons(project)
        /*      onVariants.withBuildType("debug") {
                  androidTest {
                      enabled = false
                  }
              }*/
    }

    private fun BaseExtension.applyBaseCommons(project: Project) {
        compileSdkVersion(BuildConfig.compileSdkVersion)

        defaultConfig {
            minSdk = BuildConfig.minSdkVersion
            targetSdk = BuildConfig.targetSdkVersion
            versionCode = BuildConfig.versionCode
            versionName = BuildConfig.versionName
            testInstrumentationRunner = BuildConfig.runner
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        buildFeatures.viewBinding = true
    }

}