package com.typosafe.jmh;

import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(time = 10, timeUnit = TimeUnit.MILLISECONDS, iterations = 1)
@Measurement(time = 10, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class LambdasNoWarmup extends Lambdas {}
