package com.veronica.idn.firstsubmissionjetpack.view.movie.dashboard

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class MovieViewModelTest : TestCase() {
    private lateinit var movieViewModel: MovieViewModel
    private val expectedMovieSize = 19

    @Before
    public override fun setUp() {
        movieViewModel = MovieViewModel()
    }

    @Test
    fun testGetMovies() {
        val movieData = movieViewModel.getMovies()
        assertNotNull(movieData)
        assertEquals(expectedMovieSize, movieData.size)
    }
}