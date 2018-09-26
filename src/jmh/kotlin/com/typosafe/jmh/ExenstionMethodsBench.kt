package com.typosafe.jmh

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit
import com.typosafe.Instances.*
import com.typosafe.java.Pojo
import com.typosafe.java.updateFromLoginExt

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 100, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
@Measurement(time = 200, timeUnit = TimeUnit.MILLISECONDS, iterations = 5)
@Fork(value = 1)
open class ExenstionMethodsBench {

    @Benchmark
    fun extensionFunction(bh: Blackhole) {
        val pojo = Pojo()
        for (login in logins) {
            bh.consume(pojo.updateFromLoginExt(login))
        }
    }

    @Benchmark
    fun staticFunction(bh: Blackhole) {
        val pojo = Pojo()
        for (login in logins) {
            bh.consume(Pojo.updateFromLoginStatic(pojo, login))
        }
    }

    @Benchmark
    fun companionObjectFunction(bh: Blackhole) {
        val pojo = com.typosafe.kotlin.Pojo()
        for (login in logins) {
            bh.consume(com.typosafe.kotlin.Pojo.updateFromLoginCompanion(pojo, login))
        }
    }
}