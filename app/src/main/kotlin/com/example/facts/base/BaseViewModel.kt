package com.example.facts.base

import android.arch.lifecycle.ViewModel
import com.example.facts.di.AppComponent
import com.example.facts.di.DaggerAppComponent
import com.example.facts.network.NetworkModule
import com.example.facts.ui.facts.FactsListViewModel
import com.example.facts.ui.facts.FactsViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: AppComponent = DaggerAppComponent
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is FactsListViewModel -> injector.inject(this)
            is FactsViewModel -> injector.inject(this)
        }
    }
}