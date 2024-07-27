package com.example.rv

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rv.databinding.ItemLayoutBinding

class MyAdapter(private val items: List<DataModel>, private val context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        Glide.with(context)
            .load(item.imageUrl)
            .into(holder.binding.imageView)
        holder.binding.textView.text = item.text
        holder.binding.textViewYear.text = item.textYear

        holder.itemView.setOnClickListener {
            val fragment = DetailFragment().apply {
                arguments = Bundle().apply {
                    putString("imageUrl", item.imageUrl)
                    putString("text", item.text)
                    putString("textYear", item.textYear)
                }
            }
            (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int = items.size
}