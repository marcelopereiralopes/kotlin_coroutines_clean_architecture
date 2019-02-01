package study.com.retrofitkotlincoroutines.app

import study.com.retrofitkotlincoroutines.domain.PlaceholderPhotos
import study.com.retrofitkotlincoroutines.domain.PlaceholderPosts
import study.com.retrofitkotlincoroutines.domain.PlaceholderUsers
import study.com.retrofitkotlincoroutines.domain.TmdbMovie


interface MainView {

    fun updatePosts(list: List<PlaceholderPosts>?)
    fun updateUsers(list: List<PlaceholderUsers>?)
    fun updatePhotos(list: List<PlaceholderPhotos>?)
    fun updatePopularMovies(list: List<TmdbMovie>?)
}