package com.example.restclientlearn.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restclientlearn.R
import com.example.restclientlearn.model.Comments
import kotlinx.android.synthetic.main.adapter_main.view.*

class AdapterMain(private val Results: ArrayList<Comments>) : RecyclerView.Adapter<AdapterMain.PostViewHolder>() {
    inner class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(commentResponse:Comments){
            with(itemView){
                val name = "Name = ${commentResponse.name}"
                val email = "Email = ${commentResponse.email}"
                tvName.text = name
                tvEmail.text = email
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_main,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(Results[position])
    }

    override fun getItemCount(): Int = Results.size

}