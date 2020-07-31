package me.alberto.nestedrecyclerview.models

import java.util.*

object ChildrenFactory {
    private val random = Random()

    private val names =
        arrayListOf("Aviator", "Now you can See me", "God Father", "Mission Impossible", "3 idiots")

    private val values = arrayListOf("1", "2", "3", "4", "5")

    private fun randomName(): String {
        val index = random.nextInt(names.size)
        return names[index]
    }

    private fun randomValue(): String {
        val index = random.nextInt(values.size)
        return values[index]
    }

    fun getChildren(count: Int): List<Child> {
        val children = mutableListOf<Child>()
        repeat(count) {
            val child = Child(randomValue(), randomName())
            children.add(child)
        }
        return children
    }
}