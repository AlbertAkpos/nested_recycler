package me.alberto.nestedrecyclerview.models

import java.util.*

object ParentDataFactory {
    private val random = Random()

    private val titles =
        arrayListOf("Now Playing", "Classic", "Comedy", "Action", "Horror", "TV series")

    private fun randomTitle(): String {
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun getChildren(): List<Child> {
        return ChildrenFactory.getChildren(40)
    }

    fun getParents(count: Int): List<Parent> {
        val parents = mutableListOf<Parent>()
        repeat(count) {
            val parent = Parent(randomTitle(), getChildren())
            parents.add(parent)
        }
        return parents
    }
}