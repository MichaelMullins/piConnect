package com.pi.connect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pi.connect.api.model.Script
import kotlinx.android.synthetic.main.python_script_item.view.*

class PythonScriptAdapter(private var items: List<Script> = listOf(), private val clickListener: (Script)-> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.python_script_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.scriptItemTitle.text = items[position].name
        (holder).bind(items[position], clickListener)


    }


    fun setScripts(scripts:List<Script>)
    {
        items = scripts
        notifyDataSetChanged()
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
{
    val scriptItemTitle: TextView = view.script_item_title

    fun bind(pythonScript: Script,  clickListener: (Script) -> Unit) {
        itemView.script_item_title.text = pythonScript.name
        itemView.setOnClickListener { clickListener(pythonScript)}

    }

}



