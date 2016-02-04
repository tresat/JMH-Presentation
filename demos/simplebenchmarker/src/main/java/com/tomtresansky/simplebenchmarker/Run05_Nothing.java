package com.tomtresansky.simplebenchmarker;

public final class Run05_Nothing {
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("nothing", () -> DistanceCalculator.nothing(0.0d, 1.0d, 5.0d, 10.0d));
  }
}
