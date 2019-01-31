package study.com.retrofitkotlincoroutines.usecases

import study.com.retrofitkotlincoroutines.data.PlaceholderRepository
import study.com.retrofitkotlincoroutines.domain.PlaceholderPhotos
import study.com.retrofitkotlincoroutines.domain.PlaceholderPosts
import study.com.retrofitkotlincoroutines.domain.PlaceholderUsers
import javax.inject.Inject


class UCPlaceholder @Inject constructor(val placeholderRepository: PlaceholderRepository) {

    fun getPosts(): List<PlaceholderPosts>{
        return placeholderRepository.getPosts()
    }

    fun getUsers(): List<PlaceholderUsers>{
        return placeholderRepository.getUsers()
    }
    fun getPhotos(): List<PlaceholderPhotos>{
        return placeholderRepository.getPhotos()
    }
}