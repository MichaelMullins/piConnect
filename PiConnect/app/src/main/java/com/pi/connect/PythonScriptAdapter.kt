package com.pi.connect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.python_script_item.view.*

class PythonScriptAdapter(private val items :MutableList<String>) : RecyclerView.Adapter<ViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.python_script_item, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.scriptItemTitle.text = items[position]
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val scriptItemTitle: TextView = view.script_item_title
}