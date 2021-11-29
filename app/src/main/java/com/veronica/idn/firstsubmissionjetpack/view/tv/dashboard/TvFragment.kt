package com.veronica.idn.firstsubmissionjetpack.view.tv.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.veronica.idn.firstsubmissionjetpack.databinding.FragmentTvBinding


class TvFragment : Fragment() {

    private lateinit var tvFragmentTvBinding: FragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        tvFragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return tvFragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val tvViewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[TvViewModel::class.java]
            tvFragmentTvBinding.pbTv.visibility = View.GONE
            val tv = tvViewModel.getTv()
            val tvAdapter = TvAdapter()
            tvAdapter.setTv(tv)
            tvFragmentTvBinding.rvTv.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }

}