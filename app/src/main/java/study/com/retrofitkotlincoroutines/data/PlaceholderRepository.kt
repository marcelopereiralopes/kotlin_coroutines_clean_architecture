package study.com.retrofitkotlincoroutines.data

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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

        var result = mutableListOf<PlaceholderPhotos>()

        runBlocking {

            val job = GlobalScope.launch {

                val request = placeholderApi.getPhotos()

                try {
                    val response = request.await()
                    if (response.isSuccessful){
                        result = response.body() as MutableList<PlaceholderPhotos>
                    }
                }catch (e: Exception){
                    Log.d("PlaceholderRepository", "Operation fail ${e.message}")
                }
            }
            job.join()
        }

        return result
    }
}