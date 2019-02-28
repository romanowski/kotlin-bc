package com.typosafe.kotlin

import com.typosafe.Instances


class KotlinLambdas {
    fun filterAndMap(list: List<String>): List<String> =
            list.filter { it.startsWith("Ala") }.map { it.replace(" +".toRegex(), "_").toLowerCase() }

    fun passLambda(): String {
        return Instances.printUserList { n -> n.toLowerCase().substring(2, 5) }
    }

    fun passLambdaToKotlin(): String {
        return KotlinLambdasUtils.printUserList { n -> n.toLowerCase().substring(2, 5) }
    }

    fun passClosure(prefix: String): String {
        return Instances.printUserList { n -> prefix + n.toLowerCase().substring(2, 5) }
    }
}

object KotlinLambdasUtils {
    fun printUserList(prettyPrint: (String) -> String): String {
        return (prettyPrint(
                "Ala maKota") + "\n"
                + prettyPrint("Ula maPsa") + "\n"
                + prettyPrint("Ala nieMaNic"))
    }
}