package com.tomtresansky.simplebenchmarker;

public final class Run06_Constant {
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("constant", () -> Calculator.constant(0.0d, 0.0d, 10.0d, 10.0d));
  }
}