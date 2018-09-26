package com.typosafe.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static com.typosafe.Instances.logins;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 10, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
@Measurement(time = 20, timeUnit = TimeUnit.MILLISECONDS, iterations = 5)
@Fork(value = 4)
public class PojoBench {

  @Benchmark
  public void testPojoJava(Blackhole bh){
    com.typosafe.java.Pojo pojo = new com.typosafe.java.Pojo();
    for(String name: logins){
      pojo.setName(name);
      bh.consume(pojo.getName());
    }
  }

  @Benchmark
  public void testPojoKotlin(Blackhole bh) {
    com.typosafe.kotlin.Pojo pojo = new com.typosafe.kotlin.Pojo();
    for (String name : logins) {
      pojo.setName(name);
      bh.consume(pojo.getName());
    }
  }

  @Benchmark
  public void testPojoKotlinDataClass(Blackhole bh) {
    com.typosafe.kotlin.DataPojo pojo = new com.typosafe.kotlin.DataPojo("ala", 123);
    for (String name : logins) {
      pojo.setName(name);
      bh.consume(pojo.getName());
    }
  }
}
