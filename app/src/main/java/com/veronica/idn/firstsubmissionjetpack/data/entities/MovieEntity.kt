package com.veronica.idn.firstsubmissionjetpack.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity (
    val movieId: String,
    val movieTitle: String,
    val movieDescription: String,
    val movieReleased: String,
    val movieRating : String,
    val movieGenre: String,
    val moviePoster: Int
):Parcelable