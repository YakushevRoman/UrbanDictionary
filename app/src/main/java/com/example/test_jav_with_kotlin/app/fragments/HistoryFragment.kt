package com.example.test_jav_with_kotlin.app.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.UrbanApplication
import com.example.test_jav_with_kotlin.app.adapters.HistorySearchAdapter
import com.example.test_jav_with_kotlin.app.view_models.HistoryViewModel
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao
import com.example.test_jav_with_kotlin.databinding.HistoryFragmentBinding
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class HistoryFragment : Fragment() {
    @Inject lateinit var searchDao: SearchDao
    @Inject lateinit var historySearchAdapter: HistorySearchAdapter
    private lateinit var binding: HistoryFragmentBinding

    companion object {
        fun newInstance() = HistoryFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UrbanApplication.component.inject(this)
    }

    private lateinit var viewModel: HistoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.history_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
                    return HistoryViewModel(searchDao) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }).get(HistoryViewModel::class.java)
        initViews()
    }

    private fun initViews (){
        binding.rvHistorySearchResult.layoutManager = LinearLayoutManager(context)
        binding.rvHistorySearchResult.adapter = historySearchAdapter
        viewModel.getHistorySearch().observe(viewLifecycleOwner, Observer {
            historySearchAdapter.setHistoryData(it)
        })
    }

}