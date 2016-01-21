package com.tomtresansky.benchmark;

import org.openjdk.jmh.annotations.Benchmark;

import com.tomtresansky.application.Calculator;

/**
 * A sample benchmark class for the {@link Calculator} class using JMH.
 * <p>
 * Note that {@link Benchmark} classes must <strong>NOT</strong> be
 * {@code final}.
 *
 * @author ttresans
 */
public class BasicCalculatorBenchmark {
  /**
   * Demonstrates running a benchmark with JMH for the
   * {@link Calculator#distance(double, double, double, double)} method
   * 
   * @return having the {@link Benchmark} method return a value prevents
   *         dead-code removal at run time
   */
  @Benchmark
  public double distanceFormulaBenchmark() {
    return Calculator.distance(0.0d, 0.0d, 10.0d, 10.0d);
  }
}
