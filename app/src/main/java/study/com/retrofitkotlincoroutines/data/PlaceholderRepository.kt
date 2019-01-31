package study.com.retrofitkotlincoroutines.data

import study.com.retrofitkotlincoroutines.data.service.PlaceholderApi
import study.com.retrofitkotlincoroutines.domain.PlaceholderPhotos
import study.com.retrofitkotlincoroutines.domain.PlaceholderPosts
import study.com.retrofitkotlincoroutines.domain.PlaceholderUsers
import javax.inject.Inject


class PlaceholderRepository @Inject constructor(val placeholderApi: PlaceholderApi) {

    fun getPosts(): List<PlaceholderPosts>{
        return listOf()
    }

    fun getUsers(): List<PlaceholderUsers>{
        return listOf()
    }
    fun getPhotos(): List<PlaceholderPhotos>{
        return listOf()
    }
}