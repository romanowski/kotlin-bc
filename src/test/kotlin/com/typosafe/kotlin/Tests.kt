package com.typosafe.kotlin

import com.typosafe.Instances.*
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.util.*

class Tests : StringSpec({

    "logins " {
        val original = Arrays.asList("Ala Makota", "Ola", "Ala  Mala")
        val expected = Arrays.asList("ala_makota", "ala_mala")

        kotlinLambdas.filterAndMap(original) shouldBe expected
        javaLambdas.filterAndMap(original) shouldBe expected
        kotlinLambdas.filterAndMap(logins) shouldBe javaLambdas.filterAndMap(logins)
    }
})
