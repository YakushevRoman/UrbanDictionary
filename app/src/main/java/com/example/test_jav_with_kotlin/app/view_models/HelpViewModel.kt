
package com.example.test_jav_with_kotlin.app.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelpViewModel : ViewModel() {

    private var _helpInformationText: MutableLiveData<String> = MutableLiveData()

    fun initHelpViewModelParameters() : LiveData<String>{
        val helpInformationText : LiveData<String> = _helpInformationText
        _helpInformationText.value = "This is the app for searching information about definition of words \nwebsite https://www.urbandictionary.com"
        return helpInformationText
    }



}