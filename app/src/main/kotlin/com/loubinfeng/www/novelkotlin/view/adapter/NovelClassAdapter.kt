package com.loubinfeng.www.novelkotlin.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.loubinfeng.www.novelkotlin.R
import com.loubinfeng.www.novelkotlin.domain.NovelClass

/**
 * Created by loubinfeng on 2017/6/11.
 */
class NovelClassAdapter(private val data: MutableList<NovelClass>, private val context: Context, private var action: ((Int) -> Unit?)?) : RecyclerView.Adapter<ViewHolder>() {

    private val inflater: LayoutInflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.text?.text = data[position].className
        holder?.text?.setOnClickListener {
            action?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setOnItemClickListener(action: (Int) -> Unit) {
        this.action = action
    }
}

class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    val text: TextView by lazy { itemView?.findViewById(R.id.text) as TextView }
}