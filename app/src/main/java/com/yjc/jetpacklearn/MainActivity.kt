package com.yjc.jetpacklearn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yjc.databinding.TestDataBindingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_test).setOnClickListener {
            startActivity(Intent(this, TestDataBindingActivity::class.java))
        }
    }
}
