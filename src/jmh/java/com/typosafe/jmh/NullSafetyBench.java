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
public class NullSafetyBench {

  @Benchmark
  public void java(Blackhole bh) {
    for (Object current : randomObjects) {
      bh.consume(javaMethods.size(current));
    }
  }

  @Benchmark
  public void notNullKotlin(Blackhole bh) {
    for (Object current : randomObjects) {
      bh.consume(kotlinMethods.size(current));
    }
  }

  @Benchmark
  public void nullableKotlin(Blackhole bh) {
    for (Object current : randomObjects) {
      bh.consume(kotlinMethods.safeSize(current));
    }
  }
}