package com.typosafe.kotlin


class LazyPropertySynch(private val initial: String) {
    val name: String by lazy { "synch " + initial }
}

class LazyPropertyNoSynch(private val initial: String) {
    val name: String by lazy(LazyThreadSafetyMode.NONE) { "current name " + initial }
}

class LazyPropertyPublicationSynch(private val initial: String) {
    val name: String by lazy(LazyThreadSafetyMode.PUBLICATION) { "current name " + initial }
}

class Loop {
    val loop1: String by lazy { "Loop2: " + loop2 }
    val loop2: String by lazy { "Loop1: " + loop1 }
}

fun main(arg: Array<String>){
    println(Loop().loop1)
}