package com.tomtresansky.jmh.stateandblackhole;

import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

/**
 * Benchmarks the cost of an operation involving 3 numbers, using an inner {@link State} class.
 * 
 * @author ttresans
 */
public class DemoBenchmarkWithStateClass {
  @State(Scope.Thread)
  public static class AdditionState {
    long x, y, z;

    @Setup(Level.Iteration)
    public void prepare() {
      Random random = new Random();
      x = random.nextInt(1000);
      y = random.nextInt(1000);
      z = random.nextInt(1000);
    }

    @TearDown(Level.Iteration)
    public void shutdown() {
      x = y = z = 0; // useless in this benchmark - here is where we could close files, etc.
    }
  }

  @Benchmark
  public long baseline(AdditionState state) {
    return state.x;
  }

  @Benchmark
  public long operate(AdditionState state) {
    return state.x + ((state.y - state.z) * state.z);
  }
}