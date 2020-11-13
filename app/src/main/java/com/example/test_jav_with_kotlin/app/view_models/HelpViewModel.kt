
package com.example.test_jav_with_kotlin.app.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelpViewModel : ViewModel() {

    init {
        initHelpViewModelParameters()
    }

    private var _helpInformationText: MutableLiveData<String> = MutableLiveData()
    val helpInformationText : LiveData<String> = _helpInformationText

    private fun initHelpViewModelParameters(){
        _helpInformationText.value = "This is the app for searching information about definition of words"
    }

}