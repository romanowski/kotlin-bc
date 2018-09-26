package com.typosafe.java;

import com.typosafe.Instances;

import java.util.List;
import java.util.stream.Collectors;

public class JavaLambdas {
  public List<String> filterAndMap(List<String> names) {
    return names.stream()
      .filter(name -> name.contains("Ala"))
      .map(name -> name.replaceAll(" +", "_").toLowerCase())
      .collect(Collectors.toList());
  }

  public String passLambda() {
    return Instances.printUserList(n -> n.toLowerCase().substring(2, 5));
  }

  public String passClosure(String prefix) {
    return Instances.printUserList(n -> prefix + n.toLowerCase().substring(2, 5));
  }
}
