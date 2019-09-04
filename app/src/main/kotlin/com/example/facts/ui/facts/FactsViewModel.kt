package com.example.facts.ui.facts

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.example.facts.base.BaseViewModel
import com.example.facts.model.RowsData



class FactsViewModel: BaseViewModel() {
    private val factTitle = MutableLiveData<String>()
    private val factBody = MutableLiveData<String>()
    private val visibility = MutableLiveData<Int>()

    fun bind(fact: RowsData){
        factTitle.value = fact.title
        factBody.value = fact.description
        visibility.value = if(fact.title == null || fact.title.isEmpty()) View.GONE else View.VISIBLE
    }

    /**
     * Method to bind fact title
     */
    fun getFactTitle():MutableLiveData<String>{
        return factTitle
    }

    /**
     * Method to find fact description
     */
    fun getFactBody():MutableLiveData<String>{
        return factBody
    }

    fun getVisibility():MutableLiveData<Int>{
        return visibility
    }

}