package com.yjc.databinding

import android.util.Log
import android.view.View

/**
 * author: yinjiacheng
 * date: 8/6/21 8:53 AM
 * description:
 */
class Presenter {
    fun onClick(view: View, click: Boolean) {
        Log.i("yinjiacheng", "onclick, view: $view, click: $click")
    }
}