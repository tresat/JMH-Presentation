package com.tomtresansky.simplebenchmarker;

/**
 * Demonstrate the effects of constant folding.
 * 
 * @author ttresans
 */
public final class Run10_Constant_Folding {
  private static long result;
  
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    
    benchmarker.benchmark("divide small values", () -> result = Divider.divide2());
    System.out.println("Result: " + result); // Use result
  }
}
