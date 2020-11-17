package com.example.test_jav_with_kotlin.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.databinding.RecyclerSearchItemBinding
import com.example.test_jav_with_kotlin.models.Search


class SearchResultAdapter : RecyclerView.Adapter<SearchResultAdapter.SearchHolder>() {
    private var mutableList: MutableList<Search> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        val binding: RecyclerSearchItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_search_item, parent, false)
        return SearchHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.bind(mutableList[position])
    }

    override fun getItemCount(): Int = mutableList.size

    fun  setSearchData  (searchList : List<Search>){
        mutableList.clear()
        mutableList.addAll(searchList)
        notifyDataSetChanged()
    }

    class SearchHolder(private val binding: RecyclerSearchItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(search: Search){
            binding.tvDefinition.text = search.definition
        }
    }
}