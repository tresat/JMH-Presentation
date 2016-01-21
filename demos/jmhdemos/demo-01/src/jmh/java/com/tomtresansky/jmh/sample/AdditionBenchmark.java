package com.tomtresansky.jmh.sample;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Benchmarks the cost of adding 2 numbers.
 * 
 * @see http://www.oracle.com/technetwork/articles/java/architect-benchmarking-2266277.html
 * 
 * @author ttresans
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(value = 3, jvmArgsAppend = {"-server", "-disablesystemassertions"})
public class AdditionBenchmark {
  private int x = 923;
  private int y = 123;

  @Benchmark
  @Warmup(iterations = 10, time = 3, timeUnit = TimeUnit.SECONDS)
  public int baseline() {
    return x;
  }

  @Benchmark
  @Warmup(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
  public int sum() {
    return x + y;
  }
}