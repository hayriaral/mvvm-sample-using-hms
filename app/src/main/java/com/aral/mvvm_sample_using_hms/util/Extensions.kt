package com.aral.mvvm_sample_using_hms.util

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@SuppressLint("UseCompatLoadingForDrawables")
@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(int: Int) {
    this.setImageDrawable(resources.getDrawable(int,null))
}