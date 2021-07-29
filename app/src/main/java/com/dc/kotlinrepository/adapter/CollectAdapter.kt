package com.dc.kotlinrepository.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dc.kotlinrepository.R
import com.dc.kotlinrepository.databse.Student

class CollectAdapter(private val allStudents: List<Student>?) : RecyclerView.Adapter<CollectAdapter.CollectViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectViewHolder {
        return CollectViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_collect_list, parent, false))
    }


    override fun onBindViewHolder(holder: CollectViewHolder, position: Int) {
        val student: Student? = allStudents?.get(position)
        student?.let {
            holder.tvId.text = "${position + 1}"
            holder.tvName.text = it.name
            holder.tvAge.text = "${it.age}"
        }

        holder.itemView.setOnClickListener {
            val uri: Uri = Uri.parse("https://m.youdao.com/dict?le=eng&q=" + holder.tvName.text)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = allStudents?.size?: 0

    inner class CollectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvId: TextView = itemView.findViewById(R.id.tv_id)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvAge: TextView = itemView.findViewById(R.id.tv_age)
    }

}