package com.yjc.viewbinding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yjc.viewbinding.databinding.FragmentTestViewbindingBinding

/**
 * author: yinjiacheng
 * date: 4/12/21 8:37 PM
 * description:
 */
class TestViewBindingFragment : Fragment() {

    private var binding: FragmentTestViewbindingBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestViewbindingBinding.inflate(inflater, container, false)
        binding?.text?.text = "This is ViewBinding Fragment"
        binding?.image?.setImageResource(R.mipmap.ic_launcher)
        binding?.button?.setOnClickListener {
            Log.d(TAG, "Click Button!")
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val TAG = "TestViewBindingFragment"
    }
}