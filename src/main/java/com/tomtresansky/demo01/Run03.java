package com.tomtresansky.demo01;

public class Run03 {
  static final long MAX_DURATION_MILLIS = 4_000;
  static final int MAX_LOOP = 1_000;
  static final int REPEAT = 10;
  static final int WARMUP = 5;

  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();

    benchmarker.benchmark("distance", MAX_DURATION_MILLIS, MAX_LOOP, WARMUP, REPEAT,
        () -> Calculator.distance(0.0d, 0.0d, 10.0d, 10.0d));
    
    benchmarker.benchmark("constant", MAX_DURATION_MILLIS, MAX_LOOP, WARMUP, REPEAT,
        () -> Calculator.constant(0.0d, 0.0d, 10.0d, 10.0d));
    
    benchmarker.benchmark("nothing", MAX_DURATION_MILLIS, MAX_LOOP, WARMUP, REPEAT,
        () -> Calculator.nothing(0.0d, 0.0d, 10.0d, 10.0d));
  }
}
