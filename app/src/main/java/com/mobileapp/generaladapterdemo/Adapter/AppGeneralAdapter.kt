package com.mobileapp.generaladapterdemo.Adapter
import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup



abstract class AppGeneralAdapter<DS,VH : RecyclerView.ViewHolder>(private var items:MutableList<DS?>) : RecyclerView.Adapter<VH>(){
    fun removeAt(position: Int){
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, items.size)
    }

    fun add(item : DS?){
        if(items !=null){
            items.add(item)
            notifyItemInserted(items.size)
        }
    }
    fun addAll(newItems: MutableList<DS?>){
        if(items !=null){
            items.addAll(newItems)
            notifyItemRangeInserted(items.size - newItems.size, items.size)
        }
    }

    fun updateItem(position: Int){
        notifyItemChanged(position)
    }
    fun addLoader() {
        add(null)
    }

    fun removeLoader() {
        if(items.size <= 0) return
        if(items[items.size -1] != null) return
        removeAt(items.size - 1)
    }

    fun reloadList(newData : MutableList<DS>){
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}