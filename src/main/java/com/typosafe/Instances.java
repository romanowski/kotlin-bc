package com.typosafe;

import com.typosafe.java.*;
import com.typosafe.kotlin.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Instances {

  private static Random r = new Random(556783L);


  final static public KotlinMethods kotlinMethods = new KotlinMethods();
  final static public JavaMethods javaMethods = new JavaMethods();

  final static public KotlinLambdas kotlinLambdas = new KotlinLambdas();
  final static public JavaLambdas javaLambdas = new JavaLambdas();

  final static public List<String> logins = generateLogins();

  static public List<Object> randomObjects =
    generateLogins().stream().limit(30)
      .flatMap(s -> Stream.of(randomList(), kotlinLambdas, s))
      .collect(Collectors.toList());

  static {
    Collections.shuffle(randomObjects, r);
  }

  public static String printUserList(Function<String, String> prettyPrint){
    return prettyPrint.apply(
      "Ala maKota") + "\n"
      + prettyPrint.apply("Ula maPsa") + "\n"
      + prettyPrint.apply("Ala nieMaNic");
  }

  private static List<Object>  randomList(){
    ArrayList<Object> list = new ArrayList<>();
    while(r.nextInt(20) != 0){
      list.add(r.nextInt());
    }
    return list;
  }

  private static List<String> basic() {
    return Arrays.asList("Ala Makota" + r.nextInt(100),
      "Ola" + r.nextInt(100),
      "Ala  Mala" + r.nextInt(100));
  }

  private static List<String> generateLogins() {
    return Stream.generate(Instances::basic).limit(100).flatMap(List::stream).collect(Collectors.toList());
  }

}
