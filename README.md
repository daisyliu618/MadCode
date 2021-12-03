# Android现代开发指南
Android现代开发指南（Modern Android Development ）简称(MAD)。
旨在通过搭建可复用的架构模式，实现代码复用解耦架构清晰。

# base_http(网络库)
 ## 依赖项：
    - Retrofit
    - OkHttp
    - Gson
    - RxJava Adapter 提供RxJava3CallAdapterFactory
    - RxAndroid 提供AndroidSchedulers
    - Coroutines
    - Annotation
 ## 自我实现
    - GsonConverterFactory
    - LoggingInterceptor
    - 异常处理（待实现）
    - 支持协程方式（待实现）
    - 多baseurl（待实现）




## 日志库
主要打印应用调试的一些日志，也可以将日志上传到指定服务器。
### 日志功能
- debug调试模式下打印日志，release模式下自动关闭日志。
- 调试日志打印
- 支持Json、XML格式化
- 支持支持所有基本数据类型、数组、Map、List、Bundle、Intent、Reference、Throwable、Collection
- 支持打印
- 崩溃日志存储、上传
  - 存储目录
  - 文件大小
  - 有效时间
  - 加密算法


# 资源引用与参考
1、android官网中文gradle配置指南

https://developer.android.google.cn/studio/build?hl=zh_cn

2、关于implementation、api依赖方式的区别

https://developer.android.google.cn/studio/build/dependencies?hl=zh_cn

总结：

本地依赖

A api B，B api C

那么 A 模块不仅可以引用 B 模块，还可以引用 C 模块的接口和类。

A implementation B，B implementation C
那么 A 模块只能引用 B 模块的接口和类，不能引用 C 模块，也就是说 C 对于 A 是不可见的。这样做的好处是提高了编译和链接的速度。

远程依赖：

如果B、C都是远程库，A implementation B，B implementation C。此时C 对于 A 是可见的。


更优雅地检测android应用中的大图。

https://gitee.com/null_077_5468/bitmap-canary

参考文章

1、https://juejin.cn/post/6881116198889586701