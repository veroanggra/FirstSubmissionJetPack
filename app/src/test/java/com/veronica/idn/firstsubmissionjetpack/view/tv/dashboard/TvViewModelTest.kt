package com.veronica.idn.firstsubmissionjetpack.view.tv.dashboard

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class TvViewModelTest : TestCase() {
    private lateinit var tvViewModel : TvViewModel
    private val expectedTvSize = 20

    @Before
    public override fun setUp() {
        tvViewModel = TvViewModel()
    }

    @Test
    fun testGetTv() {
        val tvShowData = tvViewModel.getTv()
        assertNotNull(tvShowData)
        assertEquals(expectedTvSize, tvShowData.size)
    }
}