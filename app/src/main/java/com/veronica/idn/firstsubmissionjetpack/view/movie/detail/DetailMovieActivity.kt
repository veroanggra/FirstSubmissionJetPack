package com.veronica.idn.firstsubmissionjetpack.view.movie.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mansao.submissionandroidjetpackpro.data.MovieEntity
import com.veronica.idn.firstsubmissionjetpack.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var detailMovieBinding: ActivityDetailMovieBinding
    private lateinit var movieDetailViewModel: DetailMovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailMovieBinding.root)
        detailMovieViewModelProvider()

    }

    private fun detailMovieViewModelProvider() {
        movieDetailViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]
        val intentDetail = intent.getStringExtra(EXTRA_DATA)
        if (intentDetail != null && intentDetail.startsWith("m", 0)) {
            movieDetailViewModel.selectedMovies(intentDetail)
            showDetailMovie(movieDetailViewModel.getMovie())
        }
    }

    private fun showDetailMovie(movie: MovieEntity) {
        detailMovieBinding.apply {
            tvTitleDetailMovie.text = movie.movieTitle
            tvGenreMovieDetail.text = movie.movieGenre
            tvDateReleasedMovie.text = movie.movieReleased
            tvDescriptionDetailMovie.text = movie.movieDescription
            tvRatingDetailMovie.text = movie.movieRating
            Glide.with(this@DetailMovieActivity).load(movie.moviePoster).centerCrop()
                .into(ivDetailMovie)
            Glide.with(this@DetailMovieActivity).load(movie.moviePoster).centerCrop()
                .into(ivPosterDetailMovie)

        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}