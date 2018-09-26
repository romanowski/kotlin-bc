package com.typosafe.kotlin


class Pojo {
    var name: String = "ala"
    var age: Int = 123

    companion object {
        fun updateFromLoginCompanion(pojo: Pojo, login: String): String {
            pojo.name = login
            pojo.age = login.length
            return "${pojo.name}-${pojo.age}"
        }
    }
}

fun Pojo.login(): String = "$name-$age"