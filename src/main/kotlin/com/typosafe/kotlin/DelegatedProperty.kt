package com.typosafe.kotlin

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class UppercaseDelegate<in T>(private var current: String) : ReadWriteProperty<T, String> {
    override fun getValue(thisRef: T, property: KProperty<*>): String {
        return current
    }

    override fun setValue(thisRef: T, property: KProperty<*>, value: String) {
        current = value.toUpperCase()
    }
}

class DelegatedProperty {
    var name: String by UppercaseDelegate("Ala")
}

interface DelegateProvider {
    fun <T : DelegateProvider> Delegate(initial: String): ReadWriteProperty<T, String>
}

abstract class AbstractField : DelegateProvider {
    var name: String by Delegate("Ala")
}

interface MyDelegageProvider : DelegateProvider {
    override fun <T : DelegateProvider> Delegate(initial: String): ReadWriteProperty<T, String> {
        return UppercaseDelegate(initial)
    }
}

open class ReallySlowDelegate : AbstractField(), MyDelegageProvider