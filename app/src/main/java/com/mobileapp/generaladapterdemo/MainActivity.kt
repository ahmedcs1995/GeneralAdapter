package com.mobileapp.generaladapterdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mobileapp.generaladapterdemo.Adapter.AppGeneralAdapter
import com.mobileapp.generaladapterdemo.ViewHolder.ItemViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mListItems = prepareListItems()

        val mAppGeneralAdapter = object : AppGeneralAdapter<String,ItemViewHolder>(mListItems){


            override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
                val item = mListItems[position]
                holder.onBind(item)
            }

            override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ItemViewHolder {

                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
                return ItemViewHolder(view){
                    showToast("Item Clicked at position = $it")
                }
            }
        }

        recycler_view.adapter = mAppGeneralAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

    }


    private fun showToast(message :String?){
        Toast.makeText(this@MainActivity,message,Toast.LENGTH_SHORT).show()
    }

    private fun prepareListItems() :MutableList<String?> {
        val mListItems :MutableList<String?> = ArrayList()

        for(i in 1..10){
            mListItems.add("List Item $i")
        }
        return mListItems
    }

}
