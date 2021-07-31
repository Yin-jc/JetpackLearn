package com.yjc.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yjc.databinding.bean.User
import com.yjc.databinding.databinding.ActivityTestDataBindingBinding

/**
 * author: yinjiacheng
 * date: 7/20/21 9:27 AM
 * description:
 */
class TestDataBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityTestDataBindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_test_data_binding)
        binding.user = User("jiacheng", "yin")

    }
}