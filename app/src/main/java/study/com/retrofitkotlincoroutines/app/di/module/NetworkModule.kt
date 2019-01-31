package study.com.retrofitkotlincoroutines.app.di.module

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import study.com.retrofitkotlincoroutines.data.service.PlaceholderApi
import study.com.retrofitkotlincoroutines.data.service.TmdbApi
import javax.inject.Named

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideTmdbApi(@Named("tmdb") retrofit: Retrofit): TmdbApi {
        return retrofit.create(TmdbApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun providePlaceholderApi(@Named("placeholder") retrofit: Retrofit): PlaceholderApi {
        return retrofit.create(PlaceholderApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideAuthInterceptor(): Interceptor {
        return Interceptor { chain ->
            val newUrl = chain.request().url()
                .newBuilder()
                .addQueryParameter("api_key", "b5be56133f7886d4a3969ab00c113a47")
                .build()

            val newRequest = chain.request()
                .newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(newRequest)
        }
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideOkHttpClient(authInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    @Named("tmdb")
    internal fun provideTmdbRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    @Named("placeholder")
    internal fun providePlaceholderRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

}