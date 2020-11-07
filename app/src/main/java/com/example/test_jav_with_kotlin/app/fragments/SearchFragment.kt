package com.example.test_jav_with_kotlin.app.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.app.UrbanApplication
import com.example.test_jav_with_kotlin.app.adapters.SearchResultAdapter
import com.example.test_jav_with_kotlin.app.view_models.SearchViewModel
import com.example.test_jav_with_kotlin.databinding.SearchFragmentBinding
import com.example.test_jav_with_kotlin.retrofit.UrbanDictionaryServiceApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SearchFragment : Fragment() {
    @Inject lateinit var api: UrbanDictionaryServiceApi
    @Inject lateinit var searchResultAdapter: SearchResultAdapter
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
        initView()
    }

    private fun initView() {
        listItemBinding.btnSearch.setOnClickListener {
            api.getListOfWords(listItemBinding.etSearch.text.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        searchResultAdapter.setSearchData(it.list)
                    }, {
                        it.printStackTrace()
                    })
        }

        listItemBinding.rvSeachResul.adapter = searchResultAdapter
        listItemBinding.rvSeachResul.layoutManager = LinearLayoutManager(context)
    }

}