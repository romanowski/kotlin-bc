package com.typosafe.jmh;

import com.typosafe.java.JLazyProperty;
import com.typosafe.kotlin.LazyProperty;
import com.typosafe.scala.SLazyProperty;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static com.typosafe.Instances.logins;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 20, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
@Measurement(time = 40, timeUnit = TimeUnit.MILLISECONDS, iterations = 5)
@Fork(value = 4)
public class LazyBench {
  @Benchmark
  public void java(Blackhole bh) {
    for (String name : logins) {
      JLazyProperty prop = new JLazyProperty(name);
      bh.consume(prop.getName());
      bh.consume(prop.getName());
      bh.consume(prop.getName());
    }
  }

  @Benchmark
  public void kotlin(Blackhole bh) {
    for (String name : logins) {
      LazyProperty prop = new LazyProperty(name);
      bh.consume(prop.getName());
      bh.consume(prop.getName());
      bh.consume(prop.getName());
    }
  }

  @Benchmark
  public void scala(Blackhole bh) {
    for (String name : logins) {
      SLazyProperty prop = new SLazyProperty(name);
      bh.consume(prop.name());
      bh.consume(prop.name());
      bh.consume(prop.name());
    }
  }
}
