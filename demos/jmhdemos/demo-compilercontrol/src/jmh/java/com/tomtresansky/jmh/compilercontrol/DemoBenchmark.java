package com.tomtresansky.jmh.compilercontrol;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class DemoBenchmark {
  int start = 0;
  
  @Benchmark
  public int inline() {
    MethodsToInline m = new MethodsToInline();
    return m.call1(m.call2(m.call3(start)));
  }
  
  @Benchmark
  public int dont_inline() {
    MethodsToNotInline m = new MethodsToNotInline();
    return m.call1(m.call2(m.call3(start)));
  }
  
  @Benchmark
  public int maybe_inline() {
    MethodsToMaybeInline m = new MethodsToMaybeInline();
    return m.call1(m.call2(m.call3(start)));
  }
}
