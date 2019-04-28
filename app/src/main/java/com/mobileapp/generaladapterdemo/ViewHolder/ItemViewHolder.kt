package com.mobileapp.generaladapterdemo.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.mobileapp.generaladapterdemo.CallBack.ItemClickListener
import com.mobileapp.generaladapterdemo.R

class ItemViewHolder<T>(private var item: View, listener: ItemClickListener) : RecyclerView.ViewHolder(item) {
    var item_textview: TextView = item.findViewById(R.id.item_textview)

    init {
        item_textview.setOnClickListener{
            if(listener == null) return@setOnClickListener
            listener.onItemClick(adapterPosition)
        }
    }

    fun onBind(item: T?) {
        if (item == null) return
        if (item is String) {
            item_textview.text = item
        }

    }
}