package com.veronica.idn.firstsubmissionjetpack.view.tv.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mansao.submissionandroidjetpackpro.data.TvShowEntity
import com.veronica.idn.firstsubmissionjetpack.databinding.ActivityDetailTvBinding

class DetailTvActivity : AppCompatActivity() {
    private lateinit var detailTvBinding: ActivityDetailTvBinding
    private lateinit var tvDetailViewModel: DetailTvViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailTvBinding = ActivityDetailTvBinding.inflate(layoutInflater)
        setContentView(detailTvBinding.root)
        detaiTvViewModelProvider()
    }

    private fun detaiTvViewModelProvider() {
        tvDetailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvViewModel::class.java]
        val intentDetail = intent.getStringExtra(EXTRA_DATA)
        if (intentDetail != null && intentDetail.startsWith("t", 0)){
            tvDetailViewModel.selectedTvShow(intentDetail)
            showDetailMovie(tvDetailViewModel.getDetailTv())
        }
    }

    private fun showDetailMovie(detailTv: TvShowEntity) {
        detailTvBinding.apply {
            tvTitleDetailTv.text = detailTv.tvTitle
            tvGenreTvDetail.text = detailTv.tvGenre
            tvDateReleasedTv.text = detailTv.tvReleased
            tvDescriptionDetailTv.text = detailTv.tvDescription
            tvRatingDetailTv.text = detailTv.tvRating

            Glide.with(this@DetailTvActivity).load(detailTv.tvPoster).into(ivDetailTv)
            Glide.with(this@DetailTvActivity).load(detailTv.tvPoster).into(ivPosterDetailTv)
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}