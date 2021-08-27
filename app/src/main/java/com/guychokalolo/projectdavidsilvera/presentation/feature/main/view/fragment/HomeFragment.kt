package com.guychokalolo.projectdavidsilvera.presentation.feature.main.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guychokalolo.projectdavidsilvera.R
import com.guychokalolo.projectdavidsilvera.presentation.feature.main.viewmodel.HomeViewModel
import com.guychokalolo.projectdavidsilvera.presentation.mapper.mainNavController
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewObserver()
        initClicksDestination()
        refreshScore(homeViewModel.getScore())
    }

    private fun initViewObserver() {
        homeViewModel.scoreUpdateEvent.observe(viewLifecycleOwner, {
            refreshScore(it.score)
        })
    }

    private fun refreshScore(score: Int) {
        homeScore.text = getString(R.string.score, score.toString())
    }

    private fun initClicksDestination() {
        btnScan.setOnClickListener {
            mainNavController().navigate(HomeFragmentDirections.actionHomeFragmentToScanFragment())
        }

        btnHistory.setOnClickListener {
            mainNavController().navigate(HomeFragmentDirections.actionHomeFragmentToHistoryFragment())
        }
    }

}