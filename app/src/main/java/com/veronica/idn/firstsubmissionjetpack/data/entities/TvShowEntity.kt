package com.veronica.idn.firstsubmissionjetpack.data.entities
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowEntity(
    val tvId: String,
    val tvTitle: String,
    val tvDescription: String,
    val tvReleased: String,
    val tvRating: String,
    val tvGenre: String,
    val tvPoster: Int

) : Parcelable