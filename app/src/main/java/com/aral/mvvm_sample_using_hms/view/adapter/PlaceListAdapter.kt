package com.aral.mvvm_sample_using_hms.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aral.mvvm_sample_using_hms.R
import com.aral.mvvm_sample_using_hms.data.model.Place
import com.aral.mvvm_sample_using_hms.databinding.ItemPlaceMainBinding
import com.aral.mvvm_sample_using_hms.util.setImageUrl

class PlaceListAdapter(private val places: MutableList<Place>) :
    RecyclerView.Adapter<PlaceListAdapter.PlaceHolder>() {

    inner class PlaceHolder(val binding: ItemPlaceMainBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemPlaceMainBinding>(
            layoutInflater,
            R.layout.item_place_main,
            parent,
            false
        )
        return PlaceHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        val place = places[position]
        holder.binding.place = place
        holder.binding.placeImageView.setImageUrl(R.drawable.ic_local_places)
    }

    override fun getItemCount(): Int = places.size

    fun setPlaces(placeList: List<Place>) {
        this.places.clear()
        this.places.addAll(placeList)
        notifyDataSetChanged()
    }
}