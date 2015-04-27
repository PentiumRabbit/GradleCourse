# Android Studio 初级入门
#### 下载

- 建议去studio中文网下载,速度很快~
- 地址: http://www.android-studio.org/
- 还有更快的:直接下载地址: https://dl.google.com/dl/android/studio/ide-zips/1.0.0/android-studio-ide-135.1629389-windows.zip
- 迅雷下,飞一般的感觉~
- 实在不行就来我这拷吧...

#### 安装

- 绿色无安装版，解压直接用

### Studio介绍(于Eclipse对比)

- studio中的 Project 相当于 Eclipse 中的工作空间
- Module(模块) == Eclipse project


#### 使用
![QQ图片20150411130140.jpg](.\QQ图片20150411130140.jpg)

- 下面防止进入之前的界面

![QQ图片20150411130303.png](.\QQ图片20150411130303.png)

- 接下来导入工程，如果之前是studio工程，可以直接选择打开，如果不是，一定要选择导入（建议都是导入，除非，自己建的完整工程）
- SDK Build-tools 最好是最新的,因为他要对应gradle,否则容易出现问题

### studio工程配置
- 配置编码
	1. 全局配置
	![QQ图片20150427111144.png](.\QQ图片20150427111144.png)
    2. 单文件配置
    ![QQ截图20150427111333.png](.\QQ截图20150427111333.png)

- svn配置

	1. studio自带SVN插件

	2. 指定本地svn
    ![QQ截图20150427111903.png](.\QQ截图20150427111903.png)

	http://www.it165.net/pro/html/201404/11412.html

	3.  settings-version control

    ![QQ截图20150414180359.png](.\QQ截图20150414180359.png)

    ![QQ截图20150414180555.png](.\QQ截图20150414180555.png)
    project:是指关联整个项目
    Director:是指关联单个目录
    
    4. 配置ignore
    ![QQ截图20150427113213.png](.\QQ截图20150427113213.png)
	![QQ截图20150427113231.png](.\QQ截图20150427113231.png)
    这里可以指定单文件,也可以指定一个目录,还可以设定规则


### Studio工程的创建
1. 使用studio创建一个工程
2. 导入一个eclipse工程
3. 由eclipse导出gradle,打开工程

### Eclipse转Studio问题处理

- 直接导入,适合小工程,目录结构简单,对于目录结构复杂的工程没办法识别(多工程依赖等)
- 由Eclipse导出gradle,然后由studio打开
	由Eclipse导出的工程,由于ADT版本更新跟不上Studio更新,导致并不能直接使用,需要修改下导出工程的配置
1.     打开导出工程目录的gradle\wrapper\gradle-wrapper将distributionUrl=http\://services.gradle.org/distributions/gradle-1.12-all.zip修改成AndroidStudio对应的gradle版本号,这个版本号可以看studio自带的gradle,去studio文件中查找 D:\Development\android-studio\gradle\gradle-2.2.1 ,所以改成2.2.1就好了
1.     打开导出工程中build文件
2.     修改classpath 'com.android.tools.build:gradle:1.1.0',这个是androiStudio gradle插件版本
3. 	   然后在studio中打开就行了,如果出现studio下载gradle的情况,  可以关掉studio,去自己的账户目录.gradle/wraper/dists/目录下,手动添加压缩包

[点击查看](http://www.open-open.com/lib/view/open1421580998718.html)
	http://www.tuicool.com/articles/Z363Yj3

	http://tools.android.com/tech-docs/new-build-system

	http://www.tuicool.com/articles/MZ77R3


### Studio目录介绍


### BUG调试

### 单元测试

- 继承AndroidTestCase,写一个public 空的构造函数
- 方法名必须以test开头 jcenter

* * *

# gradle 入门

Gradle 是以 Groovy 语言为基础，面向Java应用为主。基于DSL（领域特定语言）语法的自动化构建工具。

##### 功能
- gradle对多工程的构建支持很出色，工程依赖是gradle的第一公民。
- gradle支持局部构建。
	* 支持多方式依赖管理：包括从maven远程仓库、nexus私服、ivy仓库以及本地文件系统的jars或者dirs
- gradle是第一个构建集成工具（the first build integration tool），与ant、maven、ivy有良好的相容相关性。
- 轻松迁移：gradle适用于任何结构的工程（Gradle can adapt to any structure you have.）。你可以在同一个开发平台平行构建原工程和gradle工程。通常要求写相关测试，以保证开发的插件的相似性，这种迁移可以减少破坏性，尽可能的可靠。这也是重构的最佳实践。
- gradle的整体设计是以作为一种语言为导向的，而非成为一个严格死板的框架。
- 免费开源


##### gradle提供了什么
1. 一种可切换的，像maven一样的基于约定的构建框架，却又从不锁住你（约定优于配置）
	Switchable, build-by-convention frameworks a la Maven. But we never lock you in!
2.  强大的支持多工程的构建
3. 强大的依赖管理（基于Apache Ivy），提供最大的便利去构建你的工程
	Language for dependency based programming
4. 全力支持已有的Maven或者Ivy仓库基础建设
5. 支持传递性依赖管理，在不需要远程仓库和pom.xml和ivy配置文件的前提下
6. 基于groovy脚本构建，其build脚本使用groovy语言编写
7. 具有广泛的领域模型支持你的构建A rich domain model for describing your build.

## gradle 构建工具介绍
	Android SDK\docs中可以查看相应介绍
	Gradle本身必须有一个仓库源,否则无法运行
		什么是仓库源:仓库源就是Gralde对Android支持的一个仓库,对Android进行相应的配置,处理等信息.具体可以参考下面链接
	http://www.gradle.org/docs/2.2/userguide/dependency_management.html#sec:repositories
	默认的仓库源是jcenter.以前是mavenCentral.也可以填写自定义的地址.本地地址


    assemble
    组装项目的输出的任务
    check
    运行所有检查的任务。
    build
    这个任务将执行assemble和check。
    clean
    这个任务将清理项目的输出

    Java 项目任务
    Java 插件主要创建两个任务，它们是主要锚记任务的依赖任务：
    assemble
    jar
    这个任务将创建输出。
    check
    test
    这个任务将运行测试。
    jar任务本身会直接或间接地依赖其他任务： 例如，classes任务用于编译 Java 代码。
    testClasses任务用于编译测试，但它很少会被调用，因为test任务依赖于它 （以及classes任务）。

    一般情况下，你将可能永远只调用assemble或check，而无视其他任务。

    在这里，你可以看到Java 插件的所有任务和对它们的描述。
    Android 任务
    Android 的插件使用相同的约定配置以兼容其他插件，并添加了另外的锚记任务：
    assemble
    组装项目的输出的任务
    check
    运行所有检查的任务。
    connectedCheck
    运行需要一个已连接的设备或模拟器的检查。它们将在所有已连接的设备上并行运行。
    deviceCheck
    使用 API 连接到远程设备运行检查。这一个是在 CI 服务器上使用的。
    build
    这项任务将执行assemble 和 check
    clean
    这个任务将清理项目的输出

## 参数介绍

* apply plugin用来指定用的是哪个插件，取值有
	1. com.android.application：Android APP插件（打包得到的是.apk文件）
	2. com.android.library：Android库插件（打包得到的是.aar文件）

* android用来指定Android打包插件的相关属性，其包含如下节点

	1. compileSdkVersion(apiLevel)：设置编译时用的Android版本
	2. buildToolsVersion(buildToolsVersionName)：设置编译时使用的构建工具的版本
	3. defaultConfig：设置一些默认属性，其可用属性是buildTypes和ProductFlavors之和
	4. sourceSets：配置相关源文件的位置，当你的项目的目录结构跟默认的有区别但又不想改的时候sourceSets就派上用场了

		- aidl 设置aidi的目录
		- assets 设置assets资源目录
		- compileConfigurationName The name of the compile configuration for this source set.
		- java Java源代码目录
		- jni JNI代码目录
		- jniLibs 已编译好的JNI库目录
		- manifest 指定清单文件
		- name The name of this source set.
		- packageConfigurationName The name of the runtime configuration for this source set.
		- providedConfigurationName The name of the compiled-only configuration for this source set.
		- renderscript Renderscript源代码目录
		- res 资源目录
		- setRoot(path) 根目录

	1. signingConfigs：配置签名信息

		- keyAlias 签名的别名
		- keyPassword 密码
		- storeFile 签名文件的路径
		- storePassword 签名密码
		- storeType 类型

	1. buildTypes：配置构建类型，可打出不同类型的包，默认有debug和release两种，你还可以在增加N种

		- applicationIdSuffix 修改applicationId，在默认applicationId的基础上加后缀。在buildType中修改applicationId时只能加后缀，不能完全修改
		- debuggable 设置是否生成debug版的APK
		- jniDebuggable 设置生成的APK是否支持调试本地代码
		- minifyEnabled 设置是否执行混淆
		- multiDexEnabled Whether Multi-Dex is enabled for this variant.
		- renderscriptDebuggable 设置生成的APK是否支持调试RenderScript代码
		- renderscriptOptimLevel 设置RenderScript优化级别
		- signingConfig 设置签名信息
		- versionNameSuffix 修改版本名称，在默认版本名称的基础上加后缀。在buildType中修改版本名称时只能加后缀，不能完全修改
		- zipAlignEnabled 设置是否对APK包执行ZIP对齐优化
		- proguardFile(proguardFile) 添加一个混淆文件
		- proguardFiles(proguardFileArray) 添加多个混淆文件
		- setProguardFiles(proguardFileIterable) 设置多个混淆文件

	1. productFlavors：配置不同风格的APP，在buildTypes的基础上还可以让每一个类型的APP拥有不同的风格，所以最终打出的APK的数量就是buildTypes乘以productFlavors

		- applicationId 设置应用ID
		- multiDexEnabled Whether Multi-Dex is enabled for this variant.signingConfig Signing config used by this product flavor.
		- testApplicationId 设置测试时的应用ID
		- testFunctionalTest See instrumentation.
		- testHandleProfiling See instrumentation.
		- testInstrumentationRunner Test instrumentation runner class name.
		- versionCode 设置版本号
		- versionName 设置版本名称
		- minSdkVersion(int minSdkVersion) 设置兼容的最小SDK版本
		- minSdkVersion(String minSdkVersion) 设置兼容的最小版本
		- proguardFile(proguardFile) 添加一个混淆文件
		- proguardFiles(proguardFileArray) 添加多个混淆文件
		- setProguardFiles(proguardFileIterable) 设置多个混淆文件
		- targetSdkVersion(int targetSdkVersion) 设置目标SDK版本
		- targetSdkVersion(String targetSdkVersion) 设置目标SDK版本

	1. testOptions：设置测试相关属性

		- reportDir 设置测试报告的目录
		- resultsDir 设置测试结果的目录

	1. aaptOptions：设置AAPT的属性

		- failOnMissingConfigEntry Forces aapt to return an error if it fails to find an entry for a configuration.
		- ignoreAssets Pattern describing assets to be ignore.
		- noCompress Extensions of files that will not be stored compressed in the APK.
		- useNewCruncher Whether to use the new cruncher.

	1. lintOptions：设置Lint的属性

		- abortOnError 设置是否在lint发生错误时终止构建
		- absolutePaths Whether lint should display full paths in the error output. By default the paths are relative to the path lint was invoked from.
		- check The exact set of issues to check, or null to run the issues that are enabled by default plus any issues enabled via LintOptions.getEnable() and without issues disabled via LintOptions.getDisable(). If non-null, callers are allowed to modify this collection.
		- checkAllWarnings Returns whether lint should check all warnings, including those off by default.
		- checkReleaseBuilds Returns whether lint should check for fatal errors during release builds. Default is true. If issues with severity "fatal" are found, the release build is aborted.
		- disable The set of issue id's to suppress. Callers are allowed to modify this collection.
		- enable The set of issue id's to enable. Callers are allowed to modify this collection. To enable a given issue, add the issue ID to the returned set.
		- explainIssues Returns whether lint should include explanations for issue errors. (Note that HTML and XML reports intentionally do this unconditionally, ignoring this setting.)
		- htmlOutput The optional path to where an HTML report should be written.
		- htmlReport Whether we should write an HTML report. Default true. The location can be controlled by LintOptions.getHtmlOutput().
		- ignoreWarnings Returns whether lint will only check for errors (ignoring warnings).
		- lintConfig The default configuration file to use as a fallback.
		- noLines Whether lint should include the source lines in the output where errors occurred (true by default).
		- quiet Returns whether lint should be quiet (for example, not write informational messages such as paths to report files written).
		- severityOverrides An optional map of severity overrides. The map maps from issue id's to the corresponding severity to use, which must be "fatal", "error", "warning", or "ignore".
		- showAll Returns whether lint should include all output (e.g. include all alternate locations, not truncating long messages, etc.)
		- textOutput The optional path to where a text report should be written. The special value "stdout" can be used to point to standard output.
		- textReport Whether we should write an text report. Default false. The location can be controlled by LintOptions.getTextOutput().
		- warningsAsErrors Returns whether lint should treat all warnings as errors.
		- xmlOutput The optional path to where an XML report should be written.
		- xmlReport Whether we should write an XML report. Default true. The location can be controlled by LintOptions.getXmlOutput().
		- check(id) Adds the id to the set of issues to check.
		- check(ids) Adds the ids to the set of issues to check.
		- disable(id) Adds the id to the set of issues to enable.
		- disable(ids) Adds the ids to the set of issues to enable.
		- enable(id) Adds the id to the set of issues to enable.
		- enable(ids) Adds the ids to the set of issues to enable.
		- error(id) Adds a severity override for the given issues.
		- error(ids) Adds a severity override for the given issues.
		- fatal(id) Adds a severity override for the given issues.
		- fatal(ids) Adds a severity override for the given issues.
		- ignore(id) Adds a severity override for the given issues.
		- ignore(ids) Adds a severity override for the given issues.
		- warning(id) Adds a severity override for the given issues.
		- warning(ids) Adds a severity override for the given issues.

	1. dexOptions

		- incremental Whether to enable the incremental mode for dx. This has many limitations and may not work. Use carefully.
		- javaMaxHeapSize Sets the -JXmx value when calling dx. Format should follow the 1024M pattern.
		- jumboMode Enable jumbo mode in dx (--force-jumbo).
		- preDexLibraries Whether to pre-dex libraries. This can improve incremental builds, but clean builds may be slower.

	1. compileOptions：设置编译的相关属性

		- sourceCompatibility Language level of the source code.
		- targetCompatibility Version of the generated Java bytecode.

	1. packagingOptions：设置APK包的相关属性

		- excludes The list of excluded paths.
		- pickFirsts The list of paths where the first occurrence is packaged in the APK.
		- exclude(path) Adds an excluded paths.
		- pickFirst(path) Adds a firstPick path. First pick paths do get packaged in the APK, but only the first occurrence gets packaged.

	1. jacoco：设置JaCoCo的相关属性

		- version 设置JaCoCo的版本

	1. splits：设置如何拆分APK（比如你想拆分成arm版和x86版）

		- abi ABI settings.
		- abiFilters The list of ABI filters used for multi-apk.
		- density Density settings.
		- densityFilters The list of Density filters used for multi-apk.


* dependencies：配置依赖


## 使用

- gradle中配置变量值
`buildConfigField "boolean", "DEBUG_MODEL", "true"`
- java中调用
`java boolean isDebug=BuildConfig.DEBUG_MODEL;`


- 在Manifest文件中定义一个占位符，比如以我们之前写的umeng打包的例子为例，${UMENG_CHANNEL}，这种格式.
在 Android Studio 的 Gradle Plugin 中，每一个 APK 均是由一个 buildTypes 和一个 productFlavors 组装而成。
在默认的情况下， buildTypes 有 release 和 debug 两个分支； productFlavors 没有。
每一个 module/src 都有一个名称为 main 的文件夹。这个文件夹属于 buildTypes 和 productFlavors 基础， buildTypes 和 productFlavors 都可以访问和修改 main 文件夹中的内容。

### 介绍文件目录
- 如何创建构建多渠道的代码文件


合并规则：

1. 图片、音频、 XML 类型的 Drawable 等资源文件，将会进行文件级的覆盖
2. 字符串、颜色值、整型等资源以及 AndroidManifest.xml ，将会进行元素级的覆盖。
3. 代码资源，同一个类， buildTypes 、 productFlavors 、 main 中只能存在一次，否则会有类重复的错误
4. 覆盖等级为：buildTypes > productFlavors > main （这就是为什么 release 类型的 APK 的名称都是 Release ； debug 类型的APK 的名称都是 Debug ； buildtypesnochange 类型的 APK 的名称需要根据 productFlavors 来确定）。



- Building Apps with Over 65K Methods gradle文档中有介绍\
- The Android plugin for Gradle available in Android SDK Build Tools 21.1 and higher supports multidex as part of your build configuration.
- 在studio中无论打开多少视图界面，按Esc都能回到编辑界面
- 可以直接查看跳转到关联库的源码,Eclipse只能看到.class文件,对于多工程的很不方便
- 还能直接看support V中的源码

以下这些属性改名，原先的不能用:
``` java
runProguard -> minifyEnabled (是否混淆)
zipAlign -> zipALignEnabled (是否zip对齐)
packageName -> applicationId
jniDebugBuild-> jniDebuggable
renderscriptDebug->renderscriptDebuggable
renderscriptSupportMode->renderscriptSupportModeEnabled
renderscriptNdkMode->renderscriptNdkModeEnabled
Variant.packageApplication/zipAlign/createZipAlignTask/outputFile/processResources/processManifest使用variant.out代替，具体使用，看后面代码
```


``` groovy

apply plugin: 'com.android.application'

dependencies {
    compile fileTree(dir: 'libs', include: '*.jar')
    compile project(':BaofengDownload')
    compile project(':CoreConnect')
    compile project(':AndroidCommon')
    compile project(':ImageLoader')
}
/*
 * Copyright:  Beijing BaoFeng Technology Co., Ltd. Copyright 2014-2114,  All rights reserved
 */

//设置编码
tasks.withType(JavaCompile) {
    options.encoding = "UTF-8"
}

def versionMajor = 1;
def versionMinor = 6;
def versionPatch = 8;
//def versionBuild = 6;

def getDate() {
    def date = new Date()
    def formattedDate = date.format('MMdd')
    return formattedDate
};

android {
    compileSdkVersion 21
    buildToolsVersion "21.1.2"
    defaultConfig {
        manifestPlaceholders = [activityLabel: "defaultName"]
 		multiDexEnabled false  // 多dex支持
        manifestPlaceholders = [ UMENG_CHANNEL_VALUE:"default_channel" ]
        versionCode versionMajor * 100 + versionMinor * 10 + versionPatch
        versionName "${versionMajor}.${versionMinor}.${versionPatch}"
    }

    lintOptions {
        abortOnError false
    }

//签名
    signingConfigs {
        //你自己的keystore信息
        release {
            storeFile file("baofeng.keystore")
            storePassword "Xr780o22Qa"
            keyAlias "baofeng"
            keyPassword "Xr780o22Qa"
        }
    }

    buildTypes {

        debug {
//            debug不需要签名
//            signingConfig signingConfigs.release

//           apk名字的的后缀
            versionNameSuffix ".DEBUG"

//            buildConfig "public static final int THING_ONE = 1;"  过时
            buildConfigField "boolean", "DEBUG_MODEL", "true"
        }

//        hiapk {
//            applicationIdSuffix ".hiapk"
//        }
//        playstore {
//            applicationIdSuffix ".playstore"
//        }

        release {

            zipAlignEnabled true
            shrinkResources true //移除未使用的资源
            signingConfig signingConfigs.release
            minifyEnabled true  //是否运行混淆
//            proguardFiles getDefaultProguardFile('')            调用SDK下的混淆文件
            proguardFiles 'proguard-project.txt'
            buildConfigField "boolean", "DEBUG_MODEL", "false"



        }
    }


    productFlavors {

        /*全包渠道*/
        pczhushougouxuan {
            manifestPlaceholders = [common_channel: "pczhushougouxuan"]
        }
        guanwang {
            manifestPlaceholders = [common_channel: "guanwang"]
        }
        AB_YQ {
            manifestPlaceholders = [common_channel: "AB_YQ"]
        }
        asbaidu {
            manifestPlaceholders = [common_channel: "asbaidu"]
        }

//        /*运营渠道*/
//        ZhangTingZhuanShu {
//            applicationId = 'com.storm.market.zhuanshu'
//            manifestPlaceholders = [common_channel: "ZhangTingZhuanShu"]
//        }
    }

    sourceSets {


        main {
            manifest.srcFile 'AndroidManifest.xml'
            java.srcDirs = ['src']
            resources.srcDirs = ['src']
            aidl.srcDirs = ['src']
            renderscript.srcDirs = ['src']
            res.srcDirs = ['res']
            assets.srcDirs = ['assets']
//            http://stackoverflow.com/questions/22985384/runtime-noclassdeffounderror-exception-when-importing-from-eclipse-to-android-st/23059913#23059913
//            http://stackoverflow.com/questions/21096819/jni-and-gradle-in-android-studio/21111458#21111458
//            jniLibs.srcDirs = ['libs']  //不可行
            jni.srcDirs = []
            jniLibs.srcDir 'libs'
        }

        // Move the tests to tests/java, tests/res, etc...
        instrumentTest.setRoot('tests')

        // Move the build types to build-types/<type>
        // For instance, build-types/debug/java, build-types/debug/AndroidManifest.xml, ...
        // This moves them out of them default location under src/<type>/... which would
        // conflict with src/ being used by the main source set.
        // Adding new build types or product flavors should be accompanied
        // by a similar customization.
        debug.setRoot('build-types/debug')
        release.setRoot('build-types/release')
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_7
        targetCompatibility JavaVersion.VERSION_1_7
    }


}


```


```groovy
apply plugin: 'com.android.application'

android {
    compileSdkVersion 21
    buildToolsVersion "21.1.2"

    defaultConfig {
        applicationId "cc.bb.aa.gradle_build_variants"
        minSdkVersion 10
        targetSdkVersion 21
        versionCode 1
        versionName "1.0"
    }

    signingConfigs {
        release {
            storeFile file('keystore')
            storePassword 'helloworld'
            keyAlias 'Android Release Key'
            keyPassword 'helloworld'
        }
    }

    buildTypes {
        release {
            applicationIdSuffix '.release'
            signingConfig signingConfigs.release
            zipAlignEnabled false
        }
        debug {
            applicationIdSuffix '.debug'
            zipAlignEnabled false
        }
        buildtypesnochange {
            signingConfig signingConfigs.release
            zipAlignEnabled false
        }
    }

    productFlavors {
        playstore {
            applicationId 'cc.bb.aa.gradle_build_variants.playstore'
        }
        amazonstore {
            applicationId 'cc.bb.aa.gradle_build_variants.amazonstore'
        }
        productflavorsnochange {}
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:21.0.3'
}


```

### gradle task自定义

```java
task hello << {
    println "the current task name is $name"
    println "hello world"
}

```


#### 资料

http://blog.csdn.net/column/details/android-tech-transla.html

