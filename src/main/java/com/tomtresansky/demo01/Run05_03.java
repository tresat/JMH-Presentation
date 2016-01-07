package com.tomtresansky.demo01;

public final class Run05_03 {
  static final long MAX_DURATION_MILLIS = 4_000;
  static final int MAX_LOOP = 1_000;
  static final int REPEAT = 10;
  static final int WARMUP = 5;

  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();

    benchmarker.benchmark("nothing", MAX_DURATION_MILLIS, MAX_LOOP, WARMUP, REPEAT,
        () -> Calculator.nothing(0.0d, 0.0d, 10.0d, 10.0d));
  }
}