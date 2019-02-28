package com.typosafe.java;

public class JLazyProperty {
  private String initial;
  private String name;

  public JLazyProperty(String initial) {
    this.initial = initial;
  }

  public String getName() {
    if (name == null) {
      name = "current name" + initial;
    }
    return name;
  }
}
