package com.kaidi.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaidi.demo.R

/**
 * @创建者 ykd
 * @描述
 */
class TestAdapter(private val list: List<String>) : RecyclerView.Adapter<TestHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        return TestHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itme_test, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        holder.text.text = list[position]
    }

    override fun getItemCount(): Int = list.size
}

class TestHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val text: TextView = itemView.findViewById(R.id.text)
}
