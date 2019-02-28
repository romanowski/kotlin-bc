package com.typosafe.kotlin

class LazyProperty(private val initial: String) {
    val name: String by lazy { "synch " + initial }
}