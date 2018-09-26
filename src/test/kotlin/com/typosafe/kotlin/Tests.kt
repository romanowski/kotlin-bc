package com.typosafe.kotlin

import com.typosafe.Instances.*
import io.kotlintest.*
import io.kotlintest.specs.*
import java.util.*

class Tests: StringSpec({

    "fib in Kotlin" {
        kotlinMethods.fib("6") shouldBe 8
    }

    "fib in Java" {
        javaMethods.fib("6") shouldBe 8
    }


    "logins " {
        val original = Arrays.asList("Ala Makota", "Ola", "Ala  Mala")
        val expected = Arrays.asList("ala_makota", "ala_mala")

        kotlinLambdas.filterAndMap(original) shouldBe expected
        javaLambdas.filterAndMap(original) shouldBe expected
        kotlinLambdas.filterAndMap(logins) shouldBe javaLambdas.filterAndMap(logins)
    }
})
