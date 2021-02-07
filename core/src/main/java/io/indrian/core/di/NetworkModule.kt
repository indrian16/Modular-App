package io.indrian.core.di

import io.indrian.core.network.service.GithubUserService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    factory<Interceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    factory {
        OkHttpClient.Builder()
                .addInterceptor(get<Interceptor>())
                .build()
    }

    single {
        Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    factory { get<Retrofit>().create(GithubUserService::class.java) }

}