package com.typosafe.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import static com.typosafe.Instances.*;


@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations=10)
@Measurement(time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class Lambdas {
  @Benchmark
  public Object testLambdaJava(){
    return javaLambdas.filterAndMap(logins) ;
  }

  @Benchmark
  public Object testLambdaKotlin(){
    return kotlinLambdas.filterAndMap(logins) ;
  }

  @Benchmark
  public Object testPassingJavaLambda(){
    return javaLambdas.passLambda() ;
  }

  @Benchmark
  public Object testPassingKotlinLambda(){
    return kotlinLambdas.passLambda() ;
  }

  @Benchmark
  public Object testPassingJavaClosure(){
    return javaLambdas.passClosure("benchmarking") ;
  }

  @Benchmark
  public Object testPassingKotlinClosure(){
    return kotlinLambdas.passClosure("benchmarking") ;
  }
}

