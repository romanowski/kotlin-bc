package com.typosafe.kotlin

import com.typosafe.Instances


class KotlinLambdas {
    fun filterAndMap(list: List<String>): List<String> =
            list.filter { it.startsWith("Ala") }.map { it.replace(" +".toRegex(), "_").toLowerCase() }

    fun passClosure(): String {
        return Instances.printUserList { n -> n.toLowerCase().substring(2, 5) }
    }

    fun passClosure(prefix: String): String {
        return Instances.printUserList { n -> prefix + n.toLowerCase().substring(2, 5) }
    }
}