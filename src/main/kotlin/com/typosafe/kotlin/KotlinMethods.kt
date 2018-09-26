package com.typosafe.kotlin

import com.typosafe.Instances


class KotlinMethods {

    fun size(a: Any): Int = when (a) {
        is String ->
            a.length
        is Collection<*> ->
            a.size
        else -> 0
    }

    fun basicLenght(a: String) = a.length > 4


    fun fib(to: Any) = when (to) {
        is String -> {
            var n = Integer.parseInt(to)
            var a = 0
            var b = 1
            while (n > 0) {
                val c = a
                a += b
                b = c
                n--
            }
            a
        }
        else -> 0
    }
}