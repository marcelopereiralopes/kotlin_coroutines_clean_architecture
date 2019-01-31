package study.com.retrofitkotlincoroutines.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import study.com.retrofitkotlincoroutines.R
import study.com.retrofitkotlincoroutines.RetrofitKotlinCoroutinesApp
import study.com.retrofitkotlincoroutines.domain.PlaceholderPhotos
import study.com.retrofitkotlincoroutines.domain.PlaceholderPosts
import study.com.retrofitkotlincoroutines.domain.PlaceholderUsers
import study.com.retrofitkotlincoroutines.domain.TmdbMovie
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as RetrofitKotlinCoroutinesApp).component.inject(this)

        mainPresenter.attachView(this)

        mainPresenter.getPosts()
    }

    override fun updatePosts(list: List<PlaceholderPosts>) {
        mainPresenter.getPosts()
    }

    override fun updateUsers(list: List<PlaceholderUsers>) {
        mainPresenter.getUsers()
    }

    override fun updatePhotos(list: List<PlaceholderPhotos>) {
        mainPresenter.getPhotos()
    }

    override fun updatePopularMovies(list: List<TmdbMovie>) {
        mainPresenter.getPopularMovie()
    }
}
