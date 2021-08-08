package com.yjc.databinding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yjc.databinding.BR
import com.yjc.databinding.R
import com.yjc.databinding.databinding.ItemTestBinding

/**
 * author: yinjiacheng
 * date: 2021/8/8 15:57
 * description:
 */
class TestAdapter : RecyclerView.Adapter<TestAdapter.TestViewHolder>() {

    private lateinit var binding: ItemTestBinding
    private val data by lazy { arrayListOf("1", "2", "3") }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_test, parent, false)
        return TestViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val item = data[position]
        holder.binding.setVariable(BR.item, item)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class TestViewHolder(itemView: View, val binding: ViewDataBinding) : RecyclerView.ViewHolder(itemView)
}