package com.tomtresansky.simplebenchmarker;

/**
 * Demonstrate benchmarking a distance formula implementation and a constant function.
 * <p>
 * The results show the contant method is <strong>SLOWER</strong> than the distance method.
 * 
 * @author ttresans
 */
public final class Run02_Distance_Constant {
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("distance", () -> DistanceCalculator.distance(0.0d, 1.0d, 5.0d, 10.0d));
    benchmarker.benchmark("constant", () -> DistanceCalculator.constant(0.0d, 1.0d, 5.0d, 10.0d));
  }
}
