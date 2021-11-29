package com.veronica.idn.firstsubmissionjetpack.view.tv.detail

import androidx.lifecycle.ViewModel
import com.mansao.submissionandroidjetpackpro.data.TvShowEntity
import com.veronica.idn.firstsubmissionjetpack.data.sources.DataDummy

class DetailTvViewModel : ViewModel(){
    private lateinit var tvId : String

    fun selectedTvShow(tvId : String){
        this.tvId = tvId
    }

    fun getDetailTv(): TvShowEntity{
        lateinit var  tvs: TvShowEntity
        val tvData = DataDummy.generateDummyTvShow()
        for (i in tvData){
            if (i.tvId == tvId){
                tvs = i
            }
        }
        return tvs
    }
}