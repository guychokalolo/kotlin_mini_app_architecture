package com.guychokalolo.projectdavidsilvera.presentation.feature.main.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guychokalolo.projectdavidsilvera.R
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.domain.resource.Resource
import com.guychokalolo.projectdavidsilvera.presentation.feature.main.view.OnProductClickListener
import com.guychokalolo.projectdavidsilvera.presentation.feature.main.view.adapter.HistoryAdapter
import com.guychokalolo.projectdavidsilvera.presentation.feature.main.viewmodel.HistoryViewModel
import com.guychokalolo.projectdavidsilvera.presentation.mapper.mainNavController
import kotlinx.android.synthetic.main.fragment_history.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment(), OnProductClickListener {

    private val historyViewModel: HistoryViewModel by viewModel()
    private val historyAdapter = HistoryAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewObserver()
        initView()
        refresh()
    }

    private fun initView() {
        historyBackBtn.setOnClickListener {
            activity?.onBackPressed()
        }
        historyRecyclerView.adapter = historyAdapter
    }

    private fun refresh() {
        historyViewModel.getAllProducts()
    }

    private fun initViewObserver() {
        historyViewModel.productsResult.observe(viewLifecycleOwner, {
            if (it is Resource.Success) historyAdapter.setData(it.data)
        })
    }

    override fun onProductClicked(product: ProductEntity) {
        mainNavController().navigate(
            HistoryFragmentDirections.actionHistoryFragmentToProductFragment(
                product
            )
        )
    }
}