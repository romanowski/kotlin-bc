package com.typosafe.kotlin.apps

import com.typosafe.kotlin.*
import com.typosafe.java.*

fun main(args: Array<String> ){
    val kotlinMethods = KotlinMethods()
    val javaMethods = JavaMethods()

    val N = 1000000

    val beforeKotlin = System.nanoTime()
    for(i in 1..N) kotlinMethods.size("Ala")
    val kotlinTime = (System.nanoTime() - beforeKotlin) / 1000


    val beforeJava = System.nanoTime()
    for(i in 1..N) javaMethods.size("Ala")
    val javaTime = (System.nanoTime() - beforeJava) / 1000

    println("Running $N times. Kotlin: $kotlinTime ms Java: $javaTime ms")
}