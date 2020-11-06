package com.aral.mvvm_sample_using_hms.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aral.mvvm_sample_using_hms.R
import com.aral.mvvm_sample_using_hms.util.Constant
import com.aral.mvvm_sample_using_hms.view.adapter.PlaceListAdapter
import com.aral.mvvm_sample_using_hms.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = PlaceListAdapter(mutableListOf())
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        placesRecyclerView.adapter = adapter
        searchPlace()

//        showLoading()
//        viewModel.getCurrentPlaces().observe(this, Observer { places ->
//            hideLoading()
//            places?.let {
//                adapter.setPlaces(places)
//            }
//        })
    }

    private fun searchPlace() {
        showLoading()
        viewModel.searchPlace(Constant.mockDataLat, Constant.mockDataLng)
            .observe(this, Observer { places ->
                hideLoading()
                if (places == null) {
                    showMessage()
                } else {
                    adapter.setPlaces(places)
                }
            })
    }

    private fun showMessage() {
        Toast.makeText(baseContext, "There in no place around!", Toast.LENGTH_SHORT).show()
    }

    private fun showLoading() {
        placesRecyclerView.isEnabled = false
        progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        placesRecyclerView.isEnabled = true
        progressBar.visibility = View.GONE
    }
}