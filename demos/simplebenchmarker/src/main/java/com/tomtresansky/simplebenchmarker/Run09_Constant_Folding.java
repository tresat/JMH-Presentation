package com.tomtresansky.simplebenchmarker;

/**
 * Demonstrate the effects of constant folding.
 * 
 * @author ttresans
 */
public final class Run09_Constant_Folding {
  private static long result1, result2, result3;
  
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    
    benchmarker.benchmark("divide 1s", () -> result1 = Divider.divide1());
    System.out.println("Result 1: " + result1); // Use result1
    
    benchmarker.benchmark("divide small values", () -> result2 = Divider.divide2());
    System.out.println("Result 2: " + result2); // Use result2
    
    benchmarker.benchmark("divide large values", () -> result3 = Divider.divide3());
    System.out.println("Result 3: " + result3); // Use result3
  }
}
