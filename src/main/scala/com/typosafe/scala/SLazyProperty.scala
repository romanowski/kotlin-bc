package com.typosafe.scala

class SLazyProperty(initial: String) {
  lazy val name: String = "current name " + initial
}