package com.tomtresansky.simplebenchmarker;

/**
 * Demonstrate the effects of constant folding.
 * 
 * @author ttresans
 */
public final class Run09_Constant_Folding {
private static long result;
  
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    
    benchmarker.benchmark("divide 1s", () -> result = Divider.divide1());
    System.out.println("Result: " + result); // Use result
  }
}
