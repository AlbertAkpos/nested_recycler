package me.alberto.nestedrecyclerview.models

data class Parent(val title: String, val children: List<Child>, var isCollapse: Boolean = true)