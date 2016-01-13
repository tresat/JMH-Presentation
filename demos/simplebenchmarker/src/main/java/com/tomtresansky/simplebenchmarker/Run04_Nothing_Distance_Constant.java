package com.tomtresansky.simplebenchmarker;

public final class Run04_Nothing_Distance_Constant {
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("nothing", () -> Calculator.nothing(0.0d, 0.0d, 10.0d, 10.0d));
    benchmarker.benchmark("distance", () -> Calculator.distance(0.0d, 0.0d, 10.0d, 10.0d));
    benchmarker.benchmark("constant", () -> Calculator.constant(0.0d, 0.0d, 10.0d, 10.0d));
  }
}
