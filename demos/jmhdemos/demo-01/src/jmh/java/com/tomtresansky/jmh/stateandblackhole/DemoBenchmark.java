package com.tomtresansky.jmh.stateandblackhole;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * Benchmarks the cost of operation involving 3 numbers.
 * 
 * @see http://www.oracle.com/technetwork/articles/java/architect-benchmarking-2266277.html
 * 
 * @author ttresans
 */
@State(Scope.Thread)
public class DemoBenchmark {
  long x = 923;
  long y = 17;
  long z = 223;

  @Benchmark
  public long baseline() {
    return x;
  }

  @Benchmark
  public long operate() {
    return x + ((y - z) * z);
  }
  
  @Benchmark
  public long operate_without_state_constant_folding() {
    return 923 + ((17 - 223) * 223);
  }
  
  @Benchmark
  public void operate_without_return_dead_code() {
    @SuppressWarnings("unused")
    long result = x + ((y - z) * z);
  }
}