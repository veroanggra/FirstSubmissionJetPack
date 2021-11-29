package com.veronica.idn.firstsubmissionjetpack.view.tv.detail

import com.veronica.idn.firstsubmissionjetpack.data.sources.DataDummy
import junit.framework.TestCase
import org.junit.Before

class DetailTvViewModelTest : TestCase() {

    private lateinit var detailTvViewModel: DetailTvViewModel
    private val dummyTvData = DataDummy.generateDummyTvShow()[0]
    private val tvId = dummyTvData.tvId

    @Before
    public override fun setUp() {
        detailTvViewModel = DetailTvViewModel()
        detailTvViewModel.selectedTvShow(tvId)
    }

    fun testSelectedTvShow() {
        detailTvViewModel.selectedTvShow(dummyTvData.tvId)
        val tvData = detailTvViewModel.getDetailTv()
        assertNotNull(tvData)
        assertEquals(dummyTvData.tvId, tvData.tvId)
        assertEquals(dummyTvData.tvTitle, tvData.tvTitle)
        assertEquals(dummyTvData.tvPoster, tvData.tvPoster)
        assertEquals(dummyTvData.tvReleased, tvData.tvReleased)
        assertEquals(dummyTvData.tvGenre, tvData.tvGenre)
        assertEquals(dummyTvData.tvDescription, tvData.tvDescription)
        assertEquals(dummyTvData.tvRating, tvData.tvRating)
    }
}