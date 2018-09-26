package com.typosafe.scala

class SLazyProperty(initial: String){
  lazy val name = "current name " + initial
}

class Loop {
  val loop1: String =  "Loop2: " + loop2
  val loop2: String =  "Loop1: " + loop1
}

object Loop extends App {
  print(new Loop().loop1)
}