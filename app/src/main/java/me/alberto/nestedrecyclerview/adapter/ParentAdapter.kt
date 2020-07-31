package me.alberto.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import me.alberto.nestedrecyclerview.databinding.ParentItemBinding
import me.alberto.nestedrecyclerview.models.Parent

class ParentAdapter(private val parentItems: List<Parent>) :
    ListAdapter<Parent, ViewHolder>(DiffCallback()) {


    class DiffCallback : DiffUtil.ItemCallback<Parent>() {
        override fun areItemsTheSame(oldItem: Parent, newItem: Parent): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Parent, newItem: Parent): Boolean {
            return oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ParentItemHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return parentItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parentItems[position]
        if (holder is ParentItemHolder) {
            holder.bind(parent)
        }
    }

    class ParentItemHolder(private val binding: ParentItemBinding) : ViewHolder(binding.root) {

        fun bind(parentItem: Parent) {
            binding.header.text = parentItem.title
            binding.header.setOnClickListener {
                parentItem.isCollapse = !parentItem.isCollapse
                val list = parentItem.children
                val adapter: ChildAdapter
                adapter = if (parentItem.isCollapse) {
                    ChildAdapter(emptyList())
                } else {
                    ChildAdapter(list)
                }
                binding.rvChild.adapter = adapter
                adapter.notifyDataSetChanged()
            }
            binding.rvChild.setRecycledViewPool(viewPool)
        }

        companion object {
            fun from(parent: ViewGroup): ParentItemHolder {
                val binding =
                    ParentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ParentItemHolder(binding)
            }
        }
    }

    companion object {
        val viewPool = RecyclerView.RecycledViewPool()
    }
}