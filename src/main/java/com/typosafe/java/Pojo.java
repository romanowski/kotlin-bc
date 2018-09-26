package com.typosafe.java;

public class Pojo {
  private String name = "Ala";
  private int age = 1;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static String updateFromLoginStatic(Pojo pojo, String login){
    pojo.setName(login);
    pojo.setAge(login.length());
    return pojo.getName() + "-" + pojo.getAge();
  }
}