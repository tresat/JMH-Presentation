package com.tomtresansky.simplebenchmarker;

/**
 * Demonstrate simple benchmarking of a distance formula implementation.
 * <p>
 * Sample output:
 * 
 * <pre>
Running: distance (15 iterations)
Run 0: | 21,935,219 ops/ms (warmup) | 
Run 1: | 23,514,451 ops/ms (warmup) | 
Run 2: | 21,172,183 ops/ms (warmup) | 
Run 3: | 22,699,196 ops/ms (warmup) | 
Run 4: | 20,649,777 ops/ms (warmup) | 
Run 5: | 19,457,871 ops/ms | 
Run 6: | 20,646,967 ops/ms | 
Run 7: | 20,123,289 ops/ms | 
Run 8: | 22,661,705 ops/ms | 
Run 9: | 21,167,076 ops/ms | 
Run 10: | 22,212,452 ops/ms | 
Run 11: | 21,906,426 ops/ms | 
Run 12: | 22,213,499 ops/ms | 
Run 13: | 22,100,206 ops/ms | 
Run 14: | 21,022,568 ops/ms | 
Result: distance [ 21,351,205 ops/ms ]
 * </pre>
 * 
 * @author ttresans
 */
public final class Run01_Distance {  
  public static void main(String... args) {
    SimpleBenchmarker benchmarker = new SimpleBenchmarker();
    benchmarker.benchmark("distance", () -> DistanceCalculator.distance(0.0d, 1.0d, 5.0d, 10.0d));
  }
}
