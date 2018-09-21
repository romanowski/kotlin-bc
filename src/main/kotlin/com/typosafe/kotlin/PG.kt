package com.typosafe.kotlin

class PG {
    fun correctLength(a: Any) = when(a){
        is String ->
            a.length < 100 &&  a.length > 0
        else -> false
    }

    fun basicLenght(a: String) = a.length > 0
}