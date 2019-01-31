package study.com.retrofitkotlincoroutines.data.service

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import study.com.retrofitkotlincoroutines.domain.PlaceholderPhotos
import study.com.retrofitkotlincoroutines.domain.PlaceholderPosts
import study.com.retrofitkotlincoroutines.domain.PlaceholderUsers

interface PlaceholderApi {

    @GET("/posts")
    fun getPosts() : Deferred<Response<List<PlaceholderPosts>>>

    @GET("/users")
    fun getUsers() : Deferred<Response<List<PlaceholderUsers>>>

    @GET("/photos")
    fun getPhotos() : Deferred<Response<List<PlaceholderPhotos>>>
}
