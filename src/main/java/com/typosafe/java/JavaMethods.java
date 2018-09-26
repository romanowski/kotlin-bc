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

  public boolean baseLenght(String a) {
    return a.length() > 0;
  }


  public int fib(Object to) {
    if (to instanceof String) {
      int n = Integer.parseInt((String) to);
      int a = 0;
      int b = 1;
      while (n > 0) {
        int c = a;
        a = a + b;
        b = c;
        n--;
      }

      return a;
    }
    return 0;
  }
}
