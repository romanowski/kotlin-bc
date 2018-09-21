package com.typosafe.jmh;

import com.typesafe.java.PGJava;
import com.typosafe.kotlin.PG;

public class Instances {
    final static PG kotlinPG = new PG();
    final static PGJava javaPG = new PGJava();
}
