package com.veronica.idn.firstsubmissionjetpack.view.movie.dashboard

import androidx.lifecycle.ViewModel
import com.mansao.submissionandroidjetpackpro.data.MovieEntity
import com.veronica.idn.firstsubmissionjetpack.data.sources.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies() : List<MovieEntity> = DataDummy.generateDummyMovies()
}