package study.com.retrofitkotlincoroutines.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
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

        mainPresenter.getPhotos()
    }

    override fun updatePhotos(list: List<PlaceholderPhotos>?) {
        if (list != null && list.isNotEmpty())
            Picasso.get().load(list.last().url).into(imageView)
    }

    override fun updatePosts(list: List<PlaceholderPosts>?) {}

    override fun updateUsers(list: List<PlaceholderUsers>?) {}

    override fun updatePopularMovies(list: List<TmdbMovie>?) {}
}
