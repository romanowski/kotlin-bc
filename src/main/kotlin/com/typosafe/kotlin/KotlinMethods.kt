package com.typosafe.kotlin

class KotlinMethods {

    fun size(a: Any): Int = when (a) {
        is String ->
            a.length
        is Collection<*> ->
            a.size
        else -> 0
    }

    fun safeSize(a: Any?): Int = when (a) {
        is String ->
            a.length
        is Collection<*> ->
            a.size
        else -> 0
    }

    fun basicLength(a: String) = a.length > 4
}