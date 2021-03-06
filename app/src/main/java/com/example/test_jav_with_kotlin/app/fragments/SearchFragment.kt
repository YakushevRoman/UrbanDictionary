package com.example.test_jav_with_kotlin.app.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.UrbanApplication
import com.example.test_jav_with_kotlin.app.adapters.SearchResultAdapter
import com.example.test_jav_with_kotlin.app.view_models.SearchViewModel
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao
import com.example.test_jav_with_kotlin.databinding.SearchFragmentBinding
import com.example.test_jav_with_kotlin.di.ApplicationContextModule
import com.example.test_jav_with_kotlin.retrofit.UrbanDictionaryServiceApi
import javax.inject.Inject

class SearchFragment : Fragment() {
    @Inject lateinit var urbanDictionaryServiceApi: UrbanDictionaryServiceApi
    @Inject lateinit var searchResultAdapter: SearchResultAdapter
    @Inject lateinit var searchDao: SearchDao
    private lateinit var viewModel: SearchViewModel
    private lateinit var listItemBinding: SearchFragmentBinding

    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UrbanApplication.component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        listItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.search_fragment, container, false)
        return listItemBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        viewModel.setApi(urbanDictionaryServiceApi = urbanDictionaryServiceApi, searchDao = searchDao)
        initView()
    }

    private fun initView() {
        listItemBinding.rvSeachResul.adapter = searchResultAdapter
        listItemBinding.rvSeachResul.layoutManager = LinearLayoutManager(context)

        listItemBinding.btnSearch.setOnClickListener {
            viewModel.getSearchList(listItemBinding.etSearch.text.toString())
        }

        viewModel.searchList.observe(viewLifecycleOwner, searchResultAdapter::setSearchData)

        viewModel.lastWord.observe(viewLifecycleOwner, listItemBinding.etSearch::setText)



//        viewModel.listSearchData.observe(viewLifecycleOwner, Observer {
//            /*it.stream().forEach {
//                it.list.forEach({
//                    Log.d("TAG", "initView: ${it.definition}")
//                })
//            }*/
//        })
    }

}
