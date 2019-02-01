package study.com.retrofitkotlincoroutines.app

import study.com.retrofitkotlincoroutines.usecases.UCPlaceholder
import study.com.retrofitkotlincoroutines.usecases.UCTmdb
import javax.inject.Inject


class MainPresenter @Inject constructor(val ucPlaceholder: UCPlaceholder, val ucTmdb: UCTmdb) {

    lateinit var view: MainView

    fun attachView(view: MainView){
        this.view = view
    }

    fun getPosts() {
        val list = ucPlaceholder.getPosts()
        view.updatePosts(list)
    }

    fun getUsers() {
        val list = ucPlaceholder.getUsers()
        view.updateUsers(list)
    }

    fun getPhotos() {
        val list = ucPlaceholder.getPhotos()
        view.updatePhotos(list)
    }

    fun getPopularMovie() {
        val list = ucTmdb.getPopularMovie()
        view.updatePopularMovies(list)
    }

}