package com.typosafe.java;

public class DelegatedPropertyLikeJava {
  private String name = "Ala";

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name.toUpperCase();
  }
}
