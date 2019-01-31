package study.com.retrofitkotlincoroutines.app.di.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import study.com.retrofitkotlincoroutines.RetrofitKotlinCoroutinesApp

@Module
object AppModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideApplication() = RetrofitKotlinCoroutinesApp()
}