package study.com.retrofitkotlincoroutines.app.di.component

import dagger.Component
import study.com.retrofitkotlincoroutines.RetrofitKotlinCoroutinesApp
import study.com.retrofitkotlincoroutines.app.MainActivity
import study.com.retrofitkotlincoroutines.app.di.module.AppModule
import study.com.retrofitkotlincoroutines.app.di.module.NetworkModule
import study.com.retrofitkotlincoroutines.app.di.module.RepositoryModule
import study.com.retrofitkotlincoroutines.app.di.module.UseCaseModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(NetworkModule::class), (RepositoryModule::class), (UseCaseModule::class), (AppModule::class)])
interface AppComponent {

    fun inject(app: RetrofitKotlinCoroutinesApp)
    fun inject(activity: MainActivity)
}