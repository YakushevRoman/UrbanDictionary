package com.example.test_jav_with_kotlin.app.fragments

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.test_jav_with_kotlin.BuildConfig
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.app.view_models.HelpViewModel
import com.example.test_jav_with_kotlin.databinding.HelpFragmentBinding

class HelpFragment : Fragment() {
    private lateinit var binding: HelpFragmentBinding
    private lateinit var viewModel: HelpViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.help_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initHelpFragmentViewModel()
        initViews()
    }

    private fun initHelpFragmentViewModel(){
        viewModel = ViewModelProvider(this).get(HelpViewModel::class.java)
    }

    private fun initViews(){
        binding.tvAppVersion.text = "v ${BuildConfig.VERSION_NAME}"
    }

}