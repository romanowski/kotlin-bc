package com.typosafe.kotlin.animals

import com.typosafe.java.animals.JAnimal;

class KVeganAnimal(private val name: String): JAnimal {

    override fun eats(): String = "$name eats only grass and stuff"

    override fun name(): String = name
}


class MyKVeganAnimal(val animal: KVeganAnimal): JAnimal by animal {
    override fun name(): String = "My ${animal.name()}"
}