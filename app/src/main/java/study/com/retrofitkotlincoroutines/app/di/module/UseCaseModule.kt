package study.com.retrofitkotlincoroutines.app.di.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import study.com.retrofitkotlincoroutines.data.PlaceholderRepository
import study.com.retrofitkotlincoroutines.data.TmdbRepository
import study.com.retrofitkotlincoroutines.usecases.UCPlaceholder
import study.com.retrofitkotlincoroutines.usecases.UCTmdb

@Module
object UseCaseModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideUITmdb(tmdbRepository: TmdbRepository): UCTmdb {
        return UCTmdb(tmdbRepository)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideUIPlaceholder(placeholderRepository: PlaceholderRepository): UCPlaceholder {
        return UCPlaceholder(placeholderRepository)
    }
}