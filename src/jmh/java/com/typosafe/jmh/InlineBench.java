package com.typosafe.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.typosafe.Instances.*;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 20, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
@Measurement(time = 40, timeUnit = TimeUnit.MILLISECONDS, iterations = 5)
@Fork(value = 4)
public class InlineBench {

  @Benchmark
  public Object javaStreamOperations() {
    return javaLambdas.filterAndMap(logins);
  }

  @Benchmark
  public Object kotlinInlineMethod() {
    return kotlinLambdas.filterAndMap(logins);
  }
}