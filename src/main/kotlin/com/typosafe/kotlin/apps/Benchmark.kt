package com.typosafe.kotlin.apps

import com.typosafe.kotlin.*
import com.typosafe.java.*

fun main(args: Array<String> ){
    val kotlinMethods = KotlinMethods()
    val javaMethods = JavaMethods()


    val beforeKotlin = System.nanoTime()
    kotlinMethods.size("Ala")
    val kotlinTime = System.nanoTime() - beforeKotlin


    val beforeJava = System.nanoTime()
    javaMethods.size("Ala")
    val javaTime = System.nanoTime() - beforeJava

    println("Kotlin: $kotlinTime ns Java: $javaTime ns")
}