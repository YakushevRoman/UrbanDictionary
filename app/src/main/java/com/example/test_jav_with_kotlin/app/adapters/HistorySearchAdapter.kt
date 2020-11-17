package com.example.test_jav_with_kotlin.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.databinding.RecyclerHistoryItemBinding
import com.example.test_jav_with_kotlin.models.SearchList

class HistorySearchAdapter() : RecyclerView.Adapter<HistorySearchAdapter.HistorySearchViewHolder>() {
    private var historySearch : MutableList<SearchList> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorySearchViewHolder{
        val binding: RecyclerHistoryItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_history_item, parent, false)
        return HistorySearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistorySearchViewHolder, position: Int) {
        holder.bind(historySearch[position])
    }

    override fun getItemCount(): Int = historySearch.size

    fun setHistoryData(searchList: List<SearchList>){
        historySearch.clear()
        historySearch.addAll(searchList)
        notifyDataSetChanged()
    }

    class HistorySearchViewHolder(private val binding: RecyclerHistoryItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (searchList: SearchList){
            binding.tvHistoryWord.text = searchList.searchWord
        }
    }

}
