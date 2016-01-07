package com.tomtresansky.demo01_simplebenchmarker;

public final class Run03_Distance_Constant_Nothing {
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("distance", () -> Calculator.distance(0.0d, 0.0d, 10.0d, 10.0d));
    benchmarker.benchmark("constant", () -> Calculator.constant(0.0d, 0.0d, 10.0d, 10.0d));
    benchmarker.benchmark("nothing", () -> Calculator.nothing(0.0d, 0.0d, 10.0d, 10.0d));
  }
}
