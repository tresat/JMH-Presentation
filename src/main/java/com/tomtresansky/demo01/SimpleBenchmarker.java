package com.tomtresansky.demo01;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * A naive attempt at Stopwatch Benchmarking.
 * 
 * @author ttresans
 *
 * @see http://www.oracle.com/technetwork/articles/java/architect-benchmarking-2266277.html
 */
public final class SimpleBenchmarker {
  private final NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
  
  private final long maxDurationMillis;
  private final int maxLoopIterations;
  private final int warmupIterations;
  private final int testIterations;
  
  public SimpleBenchmarker() {
    this(1_000, // max duration = 1 second
        1_000, // or 1000 iterations, whichever comes first
        5, // number of warmup iterations
        10); // number of test iterations
  }
  
  public SimpleBenchmarker(long maxDurationMillis, int maxLoopIterations, int warmupIterations, int testIterations) {
    this.maxDurationMillis = maxDurationMillis;
    this.maxLoopIterations = maxLoopIterations;
    this.warmupIterations = warmupIterations;
    this.testIterations = testIterations;
  }
  
  public void benchmark(String name, Runnable runnable) {
    int totalIterations = warmupIterations + testIterations;

    long average = 0L;
    
    System.out.println("Running: " + name + " (" + totalIterations + " iterations)");      

    for (int i = 0; i < totalIterations; i++) {
      long nops = 0;
      long duration = 0L;
      long start = System.currentTimeMillis();

      while (duration < maxDurationMillis) {
        for (int j = 0; j < maxLoopIterations; j++) {
          runnable.run();
          nops++;
        }
        duration = System.currentTimeMillis() - start;
      }

      long throughput = nops / duration;
    
      boolean benchRun = i >= warmupIterations;
      if (benchRun) {
        average = average + throughput;
      }
      
      System.out.println("Run " + i + ": | " + formatter.format(throughput) + " ops/ms" + (!benchRun ? " (warmup) | " : " | "));
    }
    
    average = average / testIterations;
    
    System.out.println("Result: " + name + " [ " + formatter.format(average) + " ops/ms ]\n");
  }
}
