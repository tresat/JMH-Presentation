package com.tomtresansky.jmh.compilercontrol;

public final class MethodsToMaybeInline {
  public int call1(int a) {
    return a + 1;
  }
  
  public int call2(int a) {
    return a + 2;
  }
  
  public int call3(int a) {
    return a + 3;
  }
}