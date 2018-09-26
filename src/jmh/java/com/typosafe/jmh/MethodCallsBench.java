package com.typosafe.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static com.typosafe.Instances.*;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 100, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
@Measurement(time = 200, timeUnit = TimeUnit.MILLISECONDS, iterations = 5)
@Fork(value = 1)
@BenchmarkMode(Mode.Throughput)
public class MethodCallsBench {
  @Benchmark
  public void testMethodJava(Blackhole bh) {
    for (Object current : randomObjects) {
      bh.consume(javaMethods.size(current));
    }
  }

  @Benchmark
  public void testMethodKotlin(Blackhole bh) {
    for (Object current : randomObjects) {
      bh.consume(kotlinMethods.size(current));
    }
  }

  @Benchmark
  public void testSimplerMethodJava(Blackhole bh) {
    for (String name : logins) {
      bh.consume(javaMethods.baseLenght(name));
    }
  }

  @Benchmark
  public void testSimplerMethodKotlin(Blackhole bh) {
    for (String name : logins) {
      bh.consume(kotlinMethods.basicLenght(name));
    }
  }

  @Benchmark
  public void testSimplerMethodBaseline(Blackhole bh) {
    for (String name : logins) {
      bh.consume(name.length() > 0);
    }
  }

  @Benchmark
  public int testFibJava() {
    return javaMethods.fib("100");
  }

  @Benchmark
  public int testFibKotlin() {
    return kotlinMethods.fib("100");
  }

}