package com.yjc.jetpacklearn

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yjc.viewbinding.TestViewBindingFragment
import com.yjc.viewbinding.databinding.ActivityTestViewbindingBinding

/**
 * author: yinjiacheng
 * date: 4/12/21 6:09 PM
 * description:
 */
//private const val TAG: String = "TestViewBindingActivity"

class TestViewBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestViewbindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestViewbindingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*binding.text.text = "Hello Jetpack!"
        binding.image.setImageResource(R.mipmap.ic_launcher)
        binding.button.setOnClickListener {
            Log.d(TAG, "click button!")
        }*/

        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, TestViewBindingFragment(), TestViewBindingFragment::class.simpleName)
            .commit()
    }

    companion object {
        const val TAG = "TestViewBindingActivity" // public static final
        val TAG2 = "TestViewBindingActivity2" // private static final
    }
}