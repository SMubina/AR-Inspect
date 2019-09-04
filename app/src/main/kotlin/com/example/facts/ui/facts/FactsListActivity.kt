package com.example.facts.ui.facts

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.facts.R
import com.example.facts.databinding.ActivityFactListBinding
import com.example.facts.di.ViewModelFactory
import com.example.facts.utils.SharedPreferenceHelper

class FactsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFactListBinding
    private lateinit var errorSnackbar: Snackbar
    private val viewModel by lazy { ViewModelProviders.of(this, ViewModelFactory(this)).get(FactsListViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fact_list)

        SharedPreferenceHelper.initPreference(this)

        errorSnackbar = Snackbar.make(binding.root, "", Snackbar.LENGTH_INDEFINITE)

        binding.factList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.factList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.loadFacts()
        }

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage!=null) {
                errorSnackbar.setText(errorMessage)
                errorSnackbar.setAction(R.string.retry, viewModel.errorClickListener)
                errorSnackbar.show()
            } else {
                errorSnackbar.dismiss()
            }
        })
        binding.viewModel = viewModel
    }
}
