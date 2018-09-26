package com.typosafe.jmh;

import com.typosafe.java.JLazyPropertyNoSynch;
import com.typosafe.java.JLazyPropertySync;
import com.typosafe.kotlin.LazyPropertyNoSynch;
import com.typosafe.kotlin.LazyPropertyPublicationSynch;
import com.typosafe.kotlin.LazyPropertySynch;
import com.typosafe.scala.SLazyProperty;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static com.typosafe.Instances.logins;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 20, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
@Measurement(time = 40, timeUnit = TimeUnit.MILLISECONDS, iterations = 5)
@Fork(value = 4)
public class LazyBenchmark {
  @Benchmark
  public void testJavaNoSync(Blackhole bh) {
    for (String name : logins) {
      JLazyPropertyNoSynch prop = new JLazyPropertyNoSynch(name);
      bh.consume(prop.getName());
      bh.consume(prop.getName());
      bh.consume(prop.getName());
    }
  }

  @Benchmark
  public void testJavaSync(Blackhole bh) {
    for (String name : logins) {
      JLazyPropertySync prop = new JLazyPropertySync(name);
      bh.consume(prop.getName());
      bh.consume(prop.getName());
      bh.consume(prop.getName());
    }
  }

  @Benchmark
  public void testKotlinSync(Blackhole bh) {
    for (String name : logins) {
      LazyPropertySynch prop = new LazyPropertySynch(name);
      bh.consume(prop.getName());
      bh.consume(prop.getName());
      bh.consume(prop.getName());
    }
  }

  @Benchmark
  public void testKotlinNoSync(Blackhole bh) {
    for (String name : logins) {
      LazyPropertyNoSynch prop = new LazyPropertyNoSynch(name);
      bh.consume(prop.getName());
      bh.consume(prop.getName());
      bh.consume(prop.getName());
    }
  }

  @Benchmark
  public void testKotlinPublicationSynch(Blackhole bh) {
    for (String name : logins) {
      LazyPropertyPublicationSynch prop = new LazyPropertyPublicationSynch(name);
      bh.consume(prop.getName());
      bh.consume(prop.getName());
      bh.consume(prop.getName());
    }
  }

  @Benchmark
  public void testScala(Blackhole bh) {
    for (String name : logins) {
      SLazyProperty prop = new SLazyProperty(name);
      bh.consume(prop.name());
      bh.consume(prop.name());
      bh.consume(prop.name());
    }
  }
}
