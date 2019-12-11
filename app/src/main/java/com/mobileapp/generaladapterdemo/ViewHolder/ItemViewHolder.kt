package com.mobileapp.generaladapterdemo.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.mobileapp.generaladapterdemo.R

class ItemViewHolder(private var item: View, listener: (Int) -> Unit) : RecyclerView.ViewHolder(item) {
    var item_textview: TextView = item.findViewById(R.id.item_textview)

    init {
        item_textview.setOnClickListener {
            if (listener == null) return@setOnClickListener
            listener.invoke(adapterPosition)
        }
    }

    fun onBind(item: String?) {
        item?.let {
            item_textview.text = it
        }
    }
}