package com.tomtresansky.jmh.sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * Benchmarks the cost of adding 2 numbers.
 * 
 * @see http://www.oracle.com/technetwork/articles/java/architect-benchmarking-2266277.html
 * 
 * @author ttresans
 */
@State(Scope.Thread)
public class AdditionBenchmark {
  private int x = 923;
  private int y = 123;

  @Benchmark
  public int baseline() {
    return x;
  }

  @Benchmark
  public int sum() {
    return x + y;
  }
  
  @Benchmark
  public int sum_without_state_constant_folding() {
    return 923 + 123;
  }
  
  @Benchmark
  public void sum_without_return_dead_code() {
    @SuppressWarnings("unused")
    int result = x + y;
  }
}