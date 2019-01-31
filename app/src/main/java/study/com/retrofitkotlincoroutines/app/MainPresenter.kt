package study.com.retrofitkotlincoroutines.app

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import study.com.retrofitkotlincoroutines.usecases.UCPlaceholder
import study.com.retrofitkotlincoroutines.usecases.UCTmdb
import javax.inject.Inject


class MainPresenter @Inject constructor(val ucPlaceholder: UCPlaceholder, val ucTmdb: UCTmdb) {

    lateinit var view: MainView

    fun attachView(view: MainView){
        this.view = view
    }

    fun getPosts() = GlobalScope.launch {
        val list = ucPlaceholder.getPosts()
        view.updatePosts(list)
    }

    fun getUsers() = GlobalScope.launch {
        val list = ucPlaceholder.getUsers()
        view.updateUsers(list)
    }

    fun getPhotos() = GlobalScope.launch {
        val list = ucPlaceholder.getPhotos()
        view.updatePhotos(list)
    }

    fun getPopularMovie() = GlobalScope.launch {
        val list = ucTmdb.getPopularMovie()
        view.updatePopularMovies(list)
    }

}