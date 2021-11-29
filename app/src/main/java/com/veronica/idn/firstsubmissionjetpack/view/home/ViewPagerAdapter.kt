package com.veronica.idn.firstsubmissionjetpack.view.home

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.veronica.idn.firstsubmissionjetpack.view.movie.dashboard.MovieFragment
import com.veronica.idn.firstsubmissionjetpack.view.tv.dashboard.TvFragment

class ViewPagerAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment  =
        when (position) {
            0 -> MovieFragment()
            1 -> TvFragment()
            else -> Fragment()
        }


}