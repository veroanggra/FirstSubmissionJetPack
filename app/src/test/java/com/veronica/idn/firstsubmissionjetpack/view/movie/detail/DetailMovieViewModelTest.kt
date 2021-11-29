package com.veronica.idn.firstsubmissionjetpack.view.movie.detail

import com.veronica.idn.firstsubmissionjetpack.data.sources.DataDummy
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest : TestCase() {
    private lateinit var detailMovieViewModel : DetailMovieViewModel
    private val dummyMovieData = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovieData.movieId

    @Before
    public override fun setUp() {
        detailMovieViewModel = DetailMovieViewModel()
        detailMovieViewModel.selectedMovies(movieId)

    }

    @Test
    fun testSelectedMovies() {
       detailMovieViewModel.selectedMovies(dummyMovieData.movieId)
        val movieData = detailMovieViewModel.getMovie()
        assertNotNull(movieData)
        assertEquals(dummyMovieData.movieId, movieData.movieId)
        assertEquals(dummyMovieData.movieTitle, movieData.movieTitle)
        assertEquals(dummyMovieData.movieGenre, movieData.movieGenre)
        assertEquals(dummyMovieData.movieRating, movieData.movieRating)
        assertEquals(dummyMovieData.moviePoster, movieData.moviePoster)
        assertEquals(dummyMovieData.movieDescription, movieData.movieDescription)
        assertEquals(dummyMovieData.movieReleased, movieData.movieReleased)
    }
}