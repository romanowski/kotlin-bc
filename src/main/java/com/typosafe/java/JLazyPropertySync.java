package com.typosafe.java;

public class JLazyPropertySync {
  private String initial;

  public JLazyPropertySync(String initial){
    this.initial = initial;
  }

  private String name;

  public synchronized String getName(){
    if(name == null){
      name = "current name" + name;
    }
    return name;
  }
}
