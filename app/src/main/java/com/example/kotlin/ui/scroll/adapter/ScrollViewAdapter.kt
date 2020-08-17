package com.example.kotlin.ui.scroll.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R

class ScrollViewAdapter(val arrayList: ArrayList<String>) : RecyclerView.Adapter<ScrollViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScrollViewAdapter.ViewHolder {

        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.items_scrollview, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ScrollViewAdapter.ViewHolder, position: Int) {
        holder.textViewCategoryName.text = arrayList[position]

    }


   inner  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewCategoryName: AppCompatTextView = itemView.findViewById(R.id.text_view_name)

       init {
           itemView.setOnClickListener(View.OnClickListener {

           })

       }

    }
}