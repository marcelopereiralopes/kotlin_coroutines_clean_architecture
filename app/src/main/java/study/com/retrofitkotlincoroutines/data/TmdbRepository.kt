package study.com.retrofitkotlincoroutines.data

import study.com.retrofitkotlincoroutines.data.service.TmdbApi
import study.com.retrofitkotlincoroutines.domain.TmdbMovie
import javax.inject.Inject


class TmdbRepository @Inject constructor(val tmdbApi: TmdbApi) {

    fun getPopularMovie(): List<TmdbMovie>{
        return listOf()
    }
}