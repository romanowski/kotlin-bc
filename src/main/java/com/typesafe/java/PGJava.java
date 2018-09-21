package com.typesafe.java;

public class PGJava {
    public boolean correctLength(Object a){
        if (a instanceof String){
            String asString = (String)a;
            return asString.length() < 100 &&  asString.length() > 2;
        }
        return false;
    }

    public boolean baseLenght(String a){
        return a.length() > 0;
    }
}
