package com.tomtresansky.simplebenchmarker;

public final class Run06_Constant {
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("constant", () -> DistanceCalculator.constant(0.0d, 1.0d, 5.0d, 10.0d));
  }
}