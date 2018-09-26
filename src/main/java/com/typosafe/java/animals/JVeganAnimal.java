package com.typosafe.java.animals;

public class JVeganAnimal implements JAnimal {
  private String name;

  JVeganAnimal(String name){
    this.name = name;
  }

  @Override
  public String eats() {
    return  name() + " eats only grass and stuff";
  }

  @Override
  public String name() {
    return this.name;
  }
}
