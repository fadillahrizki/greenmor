package com.dicoding.greenmor.ui.info

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.greenmor.R
import java.util.*

class InfoAdapter(private val listInfo: ArrayList<Info>, private val context: Context) : RecyclerView.Adapter<InfoAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_info, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo) = listInfo[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, DetailInfoActivity::class.java))
        }

    }

    override fun getItemCount(): Int = listInfo.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.photo)
        val tvName: TextView = itemView.findViewById(R.id.name)
    }
}