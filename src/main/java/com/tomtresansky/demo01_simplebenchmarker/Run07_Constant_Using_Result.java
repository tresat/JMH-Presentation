package com.tomtresansky.demo01_simplebenchmarker;

public final class Run07_Constant_Using_Result {
  private static double result;
  
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("constant", () -> result = Calculator.constant(0.0d, 0.0d, 10.0d, 10.0d));
    
    // Use result
    System.out.println("Result: " + result);
  }
}
