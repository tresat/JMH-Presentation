package com.tomtresansky.simplebenchmarker;

public final class Run08_Distance_Using_Result {
  private static double result;
  
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("distance", () -> result = DistanceCalculator.distance(0.0d, 1.0d, 5.0d, 10.0d));
    
    // Use result
    System.out.println("Result: " + result);
  }
}
