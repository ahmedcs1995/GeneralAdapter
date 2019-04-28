package com.mobileapp.generaladapterdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mobileapp.generaladapterdemo.Adapter.AppGeneralAdapter
import com.mobileapp.generaladapterdemo.CallBack.ItemClickListener
import com.mobileapp.generaladapterdemo.ViewHolder.ItemViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var  listener : ItemClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpCallBack()

        val mListItems = prepareListItems()

        val mAppGeneralAdapter = object : AppGeneralAdapter<String>(mListItems){
            override fun onBind(viewHolder: RecyclerView.ViewHolder, item: String, position: Int) {

            }

            override fun onCreate(parent: ViewGroup, i: Int): RecyclerView.ViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
                return ItemViewHolder<String>(view,listener)
            }
        }

        recycler_view.adapter = mAppGeneralAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

    }

    private fun setUpCallBack(){
        listener = object : ItemClickListener{
            override fun onItemClick(position: Int) {
                showToast("Item Clicked at position = $position")
            }

        }
    }

    private fun showToast(message :String?){
        Toast.makeText(this@MainActivity,message,Toast.LENGTH_SHORT).show()
    }

    private fun prepareListItems() :MutableList<String> {
        val mListItems :MutableList<String> = ArrayList()

        for(i in 1..10){
            mListItems.add("List Item $i")
        }
        return mListItems
    }

}
