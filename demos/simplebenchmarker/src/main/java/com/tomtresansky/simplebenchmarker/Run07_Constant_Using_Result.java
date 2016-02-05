package com.tomtresansky.simplebenchmarker;

public final class Run07_Constant_Using_Result {
  private static double result;
  
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("constant using result", () -> result = DistanceCalculator.constant(0.0d, 1.0d, 5.0d, 10.0d));
    
    // Use result
    System.out.println("Result: " + result);
  }
}
