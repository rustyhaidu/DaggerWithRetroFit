package com.example.dagger_with_retrofit.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger_with_retrofit.R
import com.example.dagger_with_retrofit.mvvm.model.Post

class PostRecyclerAdaptor(private var postList: List<Post?>?) :
    RecyclerView.Adapter<PostRecyclerAdaptor.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_post, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return postList!!.size
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var postId: TextView = itemView.findViewById(R.id.postId)
        var title: TextView = itemView.findViewById(R.id.title)
        var body: TextView = itemView.findViewById(R.id.body)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.postId.setText(postList?.get(position)?.id.toString())
        viewHolder.title.setText(postList?.get(position)?.title)
        viewHolder.body.setText(postList?.get(position)?.body)
    }
}