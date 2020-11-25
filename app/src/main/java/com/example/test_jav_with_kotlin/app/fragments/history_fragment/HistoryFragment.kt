package com.example.test_jav_with_kotlin.app.fragments.history_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.UrbanApplication
import com.example.test_jav_with_kotlin.app.adapters.HistorySearchAdapter
import com.example.test_jav_with_kotlin.app.adapters.adapter_callback.HistorySearchItemClick
import com.example.test_jav_with_kotlin.app.view_models.HistoryViewModel
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao
import com.example.test_jav_with_kotlin.databinding.HistoryFragmentBinding
import com.example.test_jav_with_kotlin.models.SearchList
import javax.inject.Inject

class HistoryFragment : Fragment() {
    @Inject lateinit var searchDao: SearchDao
    //@Inject lateinit var historySearchAdapter: HistorySearchAdapter
    private lateinit var binding: HistoryFragmentBinding
    private lateinit var viewModel: HistoryViewModel
    private lateinit var historySearchAdapter: HistorySearchAdapter


    companion object {
        fun newInstance() = HistoryFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UrbanApplication.component.inject(this)
        initAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.history_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
        initViews()
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HistoryViewModel(searchDao) as T
            }
        }).get(HistoryViewModel::class.java)
    }

    private fun initViews (){
        binding.rvHistorySearchResult.layoutManager = LinearLayoutManager(context)
        binding.rvHistorySearchResult.adapter = historySearchAdapter
        viewModel.getHistorySearch().observe(viewLifecycleOwner, {
            historySearchAdapter.setHistoryData(it)
        })
    }

    private fun initAdapter(){
        historySearchAdapter = HistorySearchAdapter(object : HistorySearchItemClick{
            override fun onHistorySearchItemClick(searchList: SearchList) {
                val bundle = Bundle()
                bundle.putSerializable("searchList", searchList)
                findNavController().navigate(R.id.action_historyFragment_to_histotySearchDetails, bundle)
            }
        })
    }

}