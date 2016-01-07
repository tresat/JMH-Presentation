package com.tomtresansky.demo01_simplebenchmarker;


/**
 * Demonstrate simple benchmarking of a distance formula implementation and a constant function.
 * 
 * @author ttresans
 */

public final class Run02_Distance_Constant {
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("distance", () -> Calculator.distance(0.0d, 0.0d, 10.0d, 10.0d));
    benchmarker.benchmark("constant", () -> Calculator.constant(0.0d, 0.0d, 10.0d, 10.0d));
  }
}