package com.tomtresansky.jmh.sample;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

/**
 * Benchmarks the cost of adding 2 numbers, using an inner {@link State} class
 * and consuming the output with a {@link Blackhole}.
 * 
 * @author ttresans
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(value = 3, jvmArgsAppend = { "-server", "-disablesystemassertions" })
public class AdditionBenchmarkWithStateAndBlackhole {
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
  @Warmup(iterations = 10, time = 3, timeUnit = TimeUnit.SECONDS)
  public void baseline_with_state_and_blackhole(AdditionState state, Blackhole blackhole) {
    blackhole.consume(state.x);
  }

  @Benchmark
  @Warmup(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
  public void sum_with_state(AdditionState state, Blackhole blackhole) {
    blackhole.consume(state.x + state.y);
  }
}