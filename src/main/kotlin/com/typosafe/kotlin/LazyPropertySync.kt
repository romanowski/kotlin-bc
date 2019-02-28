package com.typosafe.kotlin


class LazyPropertyNoSync(private val initial: String) {
    val name: String by lazy(LazyThreadSafetyMode.NONE) { "current name " + initial }
}

class LazyPropertyPublicationSync(private val initial: String) {
    val name: String by lazy(LazyThreadSafetyMode.PUBLICATION) { "current name " + initial }
}