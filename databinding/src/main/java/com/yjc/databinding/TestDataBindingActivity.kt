package com.yjc.databinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import com.yjc.databinding.bean.User
import com.yjc.databinding.databinding.TestDataBinding

/**
 * author: yinjiacheng
 * date: 7/20/21 9:27 AM
 * description:
 */
class TestDataBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: TestDataBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_test_data_binding)
//        val binding: TestDataBinding = TestDataBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        val user = User()
        user.firstName = "jiacheng"
        user.lastName = "yin"
        user.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("yinjiacheng", "onPropertyChanged, ${(sender as User).isCheck}, $propertyId")
            }
        })
        binding.user = user
        binding.presenter = Presenter()
        binding.executePendingBindings()
    }
}