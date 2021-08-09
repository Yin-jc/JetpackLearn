package com.yjc.databinding.adapter

import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion

object TestBindingAdapter {

    @JvmStatic
    @BindingAdapter("android:padding")
    fun setPaddingHorizontal(view: View, padding: Int) {
        view.setPadding(
            padding,
            view.paddingTop,
            padding,
            view.paddingBottom
        )
    }

    @JvmStatic
    @BindingConversion
    fun convertColorToDrawable(color: Int) = ColorDrawable(color)
}