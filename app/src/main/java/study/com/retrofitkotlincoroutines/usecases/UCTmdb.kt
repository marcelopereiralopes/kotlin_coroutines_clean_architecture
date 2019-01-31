package study.com.retrofitkotlincoroutines.usecases

import study.com.retrofitkotlincoroutines.data.TmdbRepository
import study.com.retrofitkotlincoroutines.domain.TmdbMovie
import javax.inject.Inject


class UCTmdb @Inject constructor(val tmdbRepository: TmdbRepository) {

    fun getPopularMovie(): List<TmdbMovie> {
        return tmdbRepository.getPopularMovie()
    }
}