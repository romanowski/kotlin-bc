package com.typosafe.jmh;

import com.typesafe.java.PGJava;
import com.typosafe.kotlin.PG;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import static com.typosafe.jmh.Instances.javaPG;
import static com.typosafe.jmh.Instances.kotlinPG;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 1)
@State(Scope.Benchmark)
public class JavaBenchmark {

    @Param({"longString", "shortOne"})
    public String arg;


    @Benchmark
    public boolean testJava(){
        return javaPG.correctLength(arg);
    }

    @Benchmark
    public boolean testKotlin(){
        return kotlinPG.correctLength(arg);
    }

    @Benchmark
    public boolean testBaseJava(){
        return javaPG.baseLenght(arg) ;
    }

    @Benchmark
    public boolean testBaseKotlin(){
        return kotlinPG.basicLenght(arg);
    }





    @Benchmark
    public boolean baseline(){
        return "1".length() > 0;
    }
}
