package me.alberto.nestedrecyclerview.models

import java.util.*

data class Child(val name: String, val value: String, var id: UUID = UUID.randomUUID())