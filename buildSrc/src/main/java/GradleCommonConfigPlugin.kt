import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author HQL
 * Created on 2021/12/7
 * Desc: gradle公共配置插件
 */

class GradleCommonConfigPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        println("这是第一个插件啊：GradleCommonConfigPlugin")
    }

}