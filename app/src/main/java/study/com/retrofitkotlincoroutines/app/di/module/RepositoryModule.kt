package study.com.retrofitkotlincoroutines.app.di.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import study.com.retrofitkotlincoroutines.data.PlaceholderRepository
import study.com.retrofitkotlincoroutines.data.TmdbRepository
import study.com.retrofitkotlincoroutines.data.service.PlaceholderApi
import study.com.retrofitkotlincoroutines.data.service.TmdbApi

@Module
object RepositoryModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideTmdbRepository(tmdbApi: TmdbApi): TmdbRepository{
        return TmdbRepository(tmdbApi)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun providePlaceholderApi(placeholderApi: PlaceholderApi): PlaceholderRepository{
        return PlaceholderRepository(placeholderApi)
    }
}