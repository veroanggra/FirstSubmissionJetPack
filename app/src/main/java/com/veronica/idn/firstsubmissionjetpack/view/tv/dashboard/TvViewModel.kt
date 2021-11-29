package com.veronica.idn.firstsubmissionjetpack.view.tv.dashboard

import androidx.lifecycle.ViewModel
import com.mansao.submissionandroidjetpackpro.data.TvShowEntity
import com.veronica.idn.firstsubmissionjetpack.data.sources.DataDummy

class TvViewModel : ViewModel() {
    fun getTv() : List<TvShowEntity> = DataDummy.generateDummyTvShow()
}