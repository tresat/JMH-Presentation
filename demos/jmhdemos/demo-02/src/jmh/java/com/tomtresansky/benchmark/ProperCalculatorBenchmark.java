package com.tomtresansky.benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import com.tomtresansky.application.Calculator;

/**
 * Benchmarks the {@link Calculator} class, showing the effect of proper JMH
 * usage.
 * <p>
 * Data is enclosed within a {@link State}-annotated static inner class whose
 * mutable fields will prevent Java HotSpot VM from doing certain optimizations
 * that we discussed earlier.
 * 
 * @author ttresans
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(value = 3, jvmArgsAppend = {"-server", "-disablesystemassertions"})
public class ProperCalculatorBenchmark {
  @State(Scope.Thread)
  public static class Data {
    double x1 = 0.0;
    double y1 = 0.0;
    double x2 = 10.0;
    double y2 = 10.0;
  }
  
  @Benchmark
  public void baseline() {
    // Do nothing
  }

  @Benchmark
  public void baseline_inject_void(Data data, Blackhole blackhole) {
    // Do nothing
  }
  
  @Benchmark
  public double baseline_inject_return_zero(Data data, Blackhole blackhole) {
    return 0.0d;
  }
  
  @Benchmark
  public void constant_void() {
    Calculator.constant(0.0d, 0.0d, 10.0d, 10.0d); // Subject to dead-code elimination and constant folding optimizations
  }
  
  @Benchmark
  public void constant_inject_void(Data data, Blackhole blackhole) {
    Calculator.constant(data.x1, data.y1, data.x2, data.y2); // Subject to dead-code elimination
  }

  @Benchmark
  public double constant_inject_return(Data data, Blackhole blackhole) {
    return Calculator.constant(data.x1, data.y1, data.x2, data.y2); // Properly setup benchmark - Implicit blackhole
  }
  
  @Benchmark
  public void constant_inject_consume(Data data, Blackhole blackhole) {
    blackhole.consume(Calculator.constant(data.x1, data.y1, data.x2, data.y2)); // Properly setup benchmark - Explicit blackhole
  }
  
  @Benchmark
  public void distance_void() {
    Calculator.distance(0.0d, 0.0d, 10.0d, 10.0d); // Subject to dead-code elimination and constant folding optimizations
  }
  
  @Benchmark
  public void distance_inject_void(Data data, Blackhole blackhole) {
    Calculator.distance(data.x1, data.y1, data.x2, data.y2); // Subject to dead-code elimination
  }

  @Benchmark
  public double distance_inject_return(Data data, Blackhole blackhole) {
    return Calculator.distance(data.x1, data.y1, data.x2, data.y2); // Subject to constant folding optimizations
  }
  
  @Benchmark
  public void distance_inject_consume(Data data, Blackhole blackhole) {
    blackhole.consume(Calculator.distance(data.x1, data.y1, data.x2, data.y2)); // Properly setup benchmark
  }
}