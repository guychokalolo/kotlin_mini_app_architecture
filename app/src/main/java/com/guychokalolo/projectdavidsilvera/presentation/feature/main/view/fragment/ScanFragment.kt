package com.guychokalolo.projectdavidsilvera.presentation.feature.main.view.fragment

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.google.zxing.integration.android.IntentIntegrator
import com.guychokalolo.projectdavidsilvera.R
import com.guychokalolo.projectdavidsilvera.domain.resource.Resource
import com.guychokalolo.projectdavidsilvera.presentation.feature.main.viewmodel.ScanViewModel
import com.guychokalolo.projectdavidsilvera.presentation.mapper.mainNavController
import kotlinx.android.synthetic.main.fragment_scan.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ScanFragment : Fragment() {

    private val scanViewModel: ScanViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewObserver()
        scanBackButton()
        //to open the scanner in the fragment
        IntentIntegrator.forSupportFragment(this).setOrientationLocked(true).initiateScan()
    }

    private fun scanBackButton() {
        scanBackBtn.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun initViewObserver(){
        scanViewModel.productResult.observe(viewLifecycleOwner,{
            if (it is Resource.Success){
                mainNavController().navigate(ScanFragmentDirections.actionScanFragmentToProductFragment(it.data))
            }else if (it is Resource.Failure){
                Toast.makeText(context, it.throwable.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents != null) {
                Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                scanViewModel.getProduct(result.contents)
            }
        }
    }

}