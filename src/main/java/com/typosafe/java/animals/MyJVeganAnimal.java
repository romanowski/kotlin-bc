package com.typosafe.java.animals;

public class MyJVeganAnimal implements JAnimal {
  private JAnimal animal;

  MyJVeganAnimal(JAnimal animal){
    this.animal = animal;
  }

  @Override
  public String eats() {
    return animal.eats();
  }

  @Override
  public String name() {
    return "My " + animal.name();
  }
}
