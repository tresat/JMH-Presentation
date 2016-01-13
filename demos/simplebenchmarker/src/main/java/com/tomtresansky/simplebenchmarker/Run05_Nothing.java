package com.tomtresansky.simplebenchmarker;

public final class Run05_Nothing {
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("nothing", () -> Calculator.nothing(0.0d, 0.0d, 10.0d, 10.0d));
  }
}
