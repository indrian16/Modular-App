object AppConfig {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.2"
    const val applicationId = "io.indrian.modularapp"
    const val minSdkVersion = 16
    const val targetSdkVersion = 30
}

object Modules {
    const val APP = ":app"
    const val CORE = ":core"

    object Features {
        const val HOME = ":features:home"
    }
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val KOTLIN = "1.4.20"
    const val RETROFIT = "2.9.0"
    const val KOTLIN_COROUTINES = "1.4.2"

    const val GSON = "2.8.6"

    const val OK_HTTP = "4.9.0"

    // Koin
    const val KOIN = "2.2.2"
}

object Dependencies {

    // Lang
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"

    // Network
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val GSON_ADAPTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val OK_HTTP = "com.squareup.okhttp3:okhttp:${Versions.OK_HTTP}"
    const val OK_HTTP_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP}"
    const val OK_HTTP_TEST = "com.squareup.okhttp3:mockwebserver:${Versions.OK_HTTP}"

    // Converter
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"

    // Async
    const val KOTLIN_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLIN_COROUTINES}"

    // Koin
    const val KOIN = "org.koin:koin-core:${Versions.KOIN}"
    const val KOIN_TEST = "org.koin:koin-test:${Versions.KOIN}"
}