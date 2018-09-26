package com.typosafe.java;

public class JLazyPropertyNoSynch {
  private String initial;

  public JLazyPropertyNoSynch(String initial){
    this.initial = initial;
  }

  private String name;

  public String getName(){
    if(name == null){
      name = "current name" + name;
    }
    return name;
  }
}
