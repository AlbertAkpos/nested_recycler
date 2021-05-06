package me.alberto.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import me.alberto.nestedrecyclerview.databinding.ChildItemBinding
import me.alberto.nestedrecyclerview.models.Child

class ChildAdapter(private val children: List<Child>) :
    ListAdapter<Child, ViewHolder>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<Child>() {
        override fun areItemsTheSame(oldItem: Child, newItem: Child): Boolean {
            return oldItem.id === newItem.id
        }

        override fun areContentsTheSame(oldItem: Child, newItem: Child): Boolean {
            return oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ChildViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val childItem = children[position]
        if (holder is ChildViewHolder) {
            holder.bind(childItem)
        }
    }


    class ChildViewHolder(private val binding: ChildItemBinding) :
        ViewHolder(binding.root) {

        fun bind(item: Child) {
            binding.childItem = item
        }

        companion object {
            fun from(parent: ViewGroup): ChildViewHolder {
                val binding =
                    ChildItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ChildViewHolder(binding)
            }
        }
    }
}