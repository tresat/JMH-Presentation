package com.tomtresansky.jmh.compilercontrol;

import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.CompilerControl.Mode;

@CompilerControl(Mode.INLINE)
public final class MethodsToInline {
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
