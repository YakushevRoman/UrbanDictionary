package com.example.test_jav_with_kotlin.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.databinding.SearchItemBinding
import com.example.test_jav_with_kotlin.models.Search


class SearchResultAdapter : RecyclerView.Adapter<SearchResultAdapter.SearchHolder>() {
    var mutableList: MutableList<Search> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: SearchItemBinding = DataBindingUtil.inflate(inflater, R.layout.search_item, parent, false)
        return SearchHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.bind(mutableList[position])
    }

    override fun getItemCount(): Int = mutableList.size

    fun setSearchData  (searchList : List<Search>){
        mutableList.clear()
        mutableList.addAll(searchList)
        notifyDataSetChanged()
    }

    class SearchHolder(val binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(search: Search){
            binding.tvDefinition.setText(search.definition)
        }
    }
}