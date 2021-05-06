package me.alberto.nestedrecyclerview.models

import java.util.*

data class Parent(
    val title: String,
    val children: List<Child>,
    var isCollapse: Boolean = true,
    val id: UUID = UUID.randomUUID()
)