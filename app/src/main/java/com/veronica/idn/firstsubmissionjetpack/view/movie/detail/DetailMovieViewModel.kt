package com.veronica.idn.firstsubmissionjetpack.view.movie.detail

import androidx.lifecycle.ViewModel
import com.mansao.submissionandroidjetpackpro.data.MovieEntity
import com.veronica.idn.firstsubmissionjetpack.data.sources.DataDummy

class DetailMovieViewModel : ViewModel() {
    private lateinit var movieId: String

    fun selectedMovies(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        lateinit var movies: MovieEntity
        val moviesData = DataDummy.generateDummyMovies()
        for (i in moviesData) {
            if (i.movieId == movieId) {
                movies = i
            }
        }
        return movies
    }
}