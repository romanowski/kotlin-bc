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
public class BaselineBench {

  @Benchmark
  public void javaBaseline1(Blackhole bh) {
    for (String name : logins) {
      bh.consume(name.length() > 4);
    }
  }

  @Benchmark
  public void javaBaseline2(Blackhole bh) {
    for (String name : logins) {
      bh.consume(javaMethods.baseLength(name));
    }
  }

  @Benchmark
  public void javaMethod(Blackhole bh) {
    for (Object current : randomObjects) {
      bh.consume(javaMethods.size(current));
    }
  }

  @Benchmark
  public void kotlinBaseline(Blackhole bh) {
    for (String name : logins) {
      bh.consume(kotlinMethods.basicLength(name));
    }
  }

  @Benchmark
  public void testMethodKotlin(Blackhole bh) {
    for (Object current : randomObjects) {
      bh.consume(kotlinMethods.size(current));
    }
  }
}