package com.example.test_jav_with_kotlin.app.fragments.history_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.app.view_models.HistotySearchDetailsViewModel
import com.example.test_jav_with_kotlin.databinding.HistotySearchDetailsFragmentBinding
import com.example.test_jav_with_kotlin.models.SearchList

class HistotySearchDetails : Fragment() {
    private lateinit var binding: HistotySearchDetailsFragmentBinding

    companion object {
        fun newInstance() = HistotySearchDetails()
    }

    private lateinit var viewModel: HistotySearchDetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.histoty_search_details_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HistotySearchDetailsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchDetails =  arguments?.getSerializable("searchList") as SearchList
        binding.tvDetails.text = searchDetails.toString()
    }

}