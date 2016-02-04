package com.tomtresansky.jmh.sample;

import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

/**
 * Benchmarks the cost of adding 2 numbers, using an inner {@link State} class.
 * 
 * @author ttresans
 */
public class AdditionBenchmarkWithStateClass {
  @State(Scope.Thread)
  public static class AdditionState {
    public int x;
    public int y;

    @Setup(Level.Iteration)
    public void prepare() {
      Random random = new Random();
      x = random.nextInt();
      y = random.nextInt();
    }

    @TearDown(Level.Iteration)
    public void shutdown() {
      x = y = 0; // useless in this benchmark - here is where we could close files, etc.
    }
  }

  @Benchmark
  public int baseline(AdditionState state) {
    return state.x;
  }

  @Benchmark
  public int sum(AdditionState state) {
    return state.x + state.y;
  }
}