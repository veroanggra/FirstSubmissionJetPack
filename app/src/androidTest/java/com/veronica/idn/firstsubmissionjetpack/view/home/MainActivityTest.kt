package com.veronica.idn.firstsubmissionjetpack.view.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.veronica.idn.firstsubmissionjetpack.R
import com.veronica.idn.firstsubmissionjetpack.data.sources.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTv = DataDummy.generateDummyTvShow()

    @get:Rule
    var mainActivity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun showMovie(){
        onView(withText(R.string.txt_movie)).perform(click())
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun showDetailMovie(){
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tvTitleDetailMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleDetailMovie)).check(matches(withText(dummyMovie[0].movieTitle)))

        onView(withId(R.id.tvGenreMovieDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenreMovieDetail)).check(matches(withText(dummyMovie[0].movieGenre)))

        onView(withId(R.id.tvDateReleasedMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDateReleasedMovie)).check(matches(withText(dummyMovie[0].movieReleased)))

        onView(withId(R.id.tvDescriptionDetailMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDescriptionDetailMovie)).check(matches(withText(dummyMovie[0].movieDescription)))

        onView(withId(R.id.tvRatingDetailMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRatingDetailMovie)).check(matches(withText(dummyMovie[0].movieRating)))
    }

    @Test
    fun showTv(){
        onView(withText(R.string.txt_tv)).perform(click())
        onView(withId(R.id.rvTv)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }
    @Test
    fun showDetailTvShow(){
        onView(withText(R.string.txt_tv)).perform(click())
       onView(withId(R.id.rvTv)).perform(
           RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
               0, click()
           )
       )
        onView(withId(R.id.tvTitleDetailTv)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleDetailTv)).check(matches(withText(dummyTv[0].tvTitle)))

        onView(withId(R.id.tvDescriptionDetailTv)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDescriptionDetailTv)).check(matches(withText(dummyTv[0].tvDescription)))

        onView(withId(R.id.tvDateReleasedTv)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDateReleasedTv)).check(matches(withText(dummyTv[0].tvReleased)))

        onView(withId(R.id.tvGenreTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenreTvDetail)).check(matches(withText(dummyTv[0].tvGenre)))

        onView(withId(R.id.tvRatingDetailTv)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRatingDetailTv)).check(matches(withText(dummyTv[0].tvRating)))
    }
}