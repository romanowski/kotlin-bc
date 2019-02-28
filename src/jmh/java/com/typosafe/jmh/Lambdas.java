package com.typosafe.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.typosafe.Instances.javaLambdas;
import static com.typosafe.Instances.kotlinLambdas;


@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 20, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
@Measurement(time = 40, timeUnit = TimeUnit.MILLISECONDS, iterations = 5)
@Fork(value = 4)
public class Lambdas {

  @Benchmark
  public Object javaLambda() {
    return javaLambdas.passLambda();
  }

  @Benchmark
  public Object javaClosure() {
    return javaLambdas.passClosure("benchmarking");
  }

  @Benchmark
  public Object kotlinLambda() {
    return kotlinLambdas.passLambda();
  }

  public Object kotlinLambdaInKotlin() {
    return kotlinLambdas.passLambdaToKotlin();
  }

  @Benchmark
  public Object kotlinClosure() {
    return kotlinLambdas.passClosure("benchmarking");
  }
}

