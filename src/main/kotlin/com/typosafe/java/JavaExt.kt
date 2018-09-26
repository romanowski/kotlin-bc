package com.typosafe.java


fun Pojo.updateFromLoginExt(login: String): String {
    name = login
    age = login.length
    return "$name-$age"
}