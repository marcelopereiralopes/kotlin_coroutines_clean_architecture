package study.com.retrofitkotlincoroutines

import android.app.Application
import study.com.retrofitkotlincoroutines.app.di.component.AppComponent
import study.com.retrofitkotlincoroutines.app.di.component.DaggerAppComponent
import study.com.retrofitkotlincoroutines.app.di.module.AppModule
import study.com.retrofitkotlincoroutines.app.di.module.NetworkModule
import study.com.retrofitkotlincoroutines.app.di.module.RepositoryModule
import study.com.retrofitkotlincoroutines.app.di.module.UseCaseModule

class RetrofitKotlinCoroutinesApp : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule)
            .networkModule(NetworkModule)
            .repositoryModule(RepositoryModule)
            .useCaseModule(UseCaseModule)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}