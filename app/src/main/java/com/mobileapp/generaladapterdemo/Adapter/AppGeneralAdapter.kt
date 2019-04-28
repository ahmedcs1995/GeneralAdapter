package com.mobileapp.generaladapterdemo.Adapter
import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup


abstract class AppGeneralAdapter<T>(private var listItems: MutableList<T>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        return onCreate(viewGroup, i)
    }

    override fun onBindViewHolder(@NonNull viewHolder: RecyclerView.ViewHolder, position: Int) {
        onBind(viewHolder, listItems!![position], position)
    }

    override fun getItemCount(): Int {
        return if (listItems == null) 0 else listItems!!.size
    }

    abstract fun onBind(@NonNull viewHolder: RecyclerView.ViewHolder, item: T, position: Int)


    abstract fun onCreate(@NonNull parent: ViewGroup, i: Int): RecyclerView.ViewHolder

    fun removeAt(position: Int){
            listItems?.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, listItems?.size!!)
    }

    fun add(item : T){
        if(listItems !=null){
            listItems?.add(item)
            notifyItemInserted(listItems?.size!! - 1)
        }
    }
    fun addAll(items: MutableList<T>){
        if(listItems !=null){
            listItems?.addAll(items)
            notifyItemRangeInserted(listItems?.size!! - items.size,listItems?.size!!)
        }
    }
    fun updateListItem(position: Int){
        notifyItemChanged(position)
    }


}