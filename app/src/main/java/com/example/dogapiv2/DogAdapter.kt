package com.example.dogapiv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dog_cardview.view.*

class DogAdapter (var list:ArrayList<String>): RecyclerView.Adapter<DogAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogAdapter.ViewHolder {
        val layout = LayoutInflater.from(parent?.context).inflate(R.layout.dog_cardview,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DogAdapter.ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(data:String){
            Glide.with(itemView.context).load(data).into(itemView.thumbnail)
        }
    }
}