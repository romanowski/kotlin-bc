package com.typosafe.jmh;

import com.typosafe.java.DelegatedPropertyLikeJava;
import com.typosafe.kotlin.DelegatedProperty;
import com.typosafe.kotlin.ReallySlowDelegate;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static com.typosafe.Instances.logins;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 10, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
@Measurement(time = 20, timeUnit = TimeUnit.MILLISECONDS, iterations = 5)
@Fork(value = 4)
public class PropertyDelegateBench {
  @Benchmark
  public void testPropertyDelegateBaseline(Blackhole bh){
    com.typosafe.kotlin.Pojo pojo = new com.typosafe.kotlin.Pojo();
    for(String name: logins){
      pojo.setName(name.toLowerCase());
      bh.consume(pojo.getName());
    }
  }

  @Benchmark
  public void testPropertyDelegateJava(Blackhole bh){
    DelegatedPropertyLikeJava pojo = new DelegatedPropertyLikeJava();
    for(String name: logins){
      pojo.setName(name);
      bh.consume(pojo.getName());
    }
  }

  @Benchmark
  public void testPropertyDelegateKotlin(Blackhole bh){
    DelegatedProperty pojo = new DelegatedProperty();
    for(String name: logins){
      pojo.setName(name);
      bh.consume(pojo.getName());
    }
  }


  @Benchmark
  public void testPropertyDelegateKotlinSlow(Blackhole bh){
    ReallySlowDelegate pojo = new ReallySlowDelegate();
    for(String name: logins){
      pojo.setName(name);
      bh.consume(pojo.getName());
    }
  }


}
