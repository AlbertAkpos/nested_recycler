package me.alberto.nestedrecyclerview.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:itemList", "app:isCollapse", "app:adapter")
fun <T : Any> RecyclerView.setRecyclerView(
    items: List<T>,
    isCollapse: Boolean,
    adapter: Any
) {
    val myAdapter = adapter as ListAdapter<T, RecyclerView.ViewHolder>
    if (isCollapse) {
        myAdapter.submitList(emptyList())
    } else {
        myAdapter.submitList(items)
    }
}