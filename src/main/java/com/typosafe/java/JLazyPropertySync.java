package com.typosafe.java;

public class JLazyPropertySync {
  private String initial;
  private String name;

  public JLazyPropertySync(String initial) {
    this.initial = initial;
  }

  public synchronized String getName() {
    if (name == null) {
      name = "current name" + initial;
    }
    return name;
  }
}
