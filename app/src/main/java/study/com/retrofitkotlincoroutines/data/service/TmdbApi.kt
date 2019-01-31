package study.com.retrofitkotlincoroutines.data.service

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import study.com.retrofitkotlincoroutines.domain.TmdbMovie

interface TmdbApi {

    @GET("movie/popular")
    fun getPopularMovie(): Deferred<Response<List<TmdbMovie>>>

}
