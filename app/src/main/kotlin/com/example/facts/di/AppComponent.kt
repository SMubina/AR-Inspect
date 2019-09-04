package com.example.facts.di

import dagger.Component
import com.example.facts.network.NetworkModule
import com.example.facts.ui.facts.FactsListViewModel
import com.example.facts.ui.facts.FactsViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface AppComponent {

    fun inject(factsListViewModel: FactsListViewModel)

    fun inject(factsViewModel: FactsViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun networkModule(networkModule: NetworkModule): Builder
    }
}