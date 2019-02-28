package com.typosafe.java;

import java.util.Collection;

public class JavaMethods {

  public int size(Object a) {
    if (a instanceof String) {
      String asString = (String) a;
      return asString.length();
    }
    if (a instanceof Collection) {
      Collection<?> asString = (Collection<?>) a;
      return asString.size();
    }
    return 1;
  }

  public boolean baseLength(String a) {
    return a.length() > 0;
  }
}
