package com.typosafe.kotlin.apps

import com.typosafe.java.JavaMethods
import com.typosafe.kotlin.KotlinMethods

fun main(args: Array<String>) {
    val kotlinMethods = KotlinMethods()
    val javaMethods = JavaMethods()

    val N = 30000000

    val beforeKotlin = System.nanoTime()
    for (i in 1..N) kotlinMethods.size("Ala")
    val kotlinTime = (System.nanoTime() - beforeKotlin) / 1000


    val beforeJava = System.nanoTime()
    for (i in 1..N) javaMethods.size("Ala")
    val javaTime = (System.nanoTime() - beforeJava) / 1000

    println("Running $N times. Kotlin: $kotlinTime us Java: $javaTime ms")
}