package com.veronica.idn.firstsubmissionjetpack.view.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.veronica.idn.firstsubmissionjetpack.R
import com.veronica.idn.firstsubmissionjetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val viewPagerAdapter = ViewPagerAdapter(this)
            mainBinding.vpMain.adapter = viewPagerAdapter
        val tabLayout: TabLayout = mainBinding.tlMain
        TabLayoutMediator(tabLayout, mainBinding.vpMain){ tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

    }
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.txt_movie,
            R.string.txt_tv
        )

        fun getLaunchService(from: Context) =
            Intent(from, MainActivity::class.java).apply {
                addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
                            or Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
            }

    }
}