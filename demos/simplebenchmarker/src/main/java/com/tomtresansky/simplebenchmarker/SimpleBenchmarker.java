package com.tomtresansky.simplebenchmarker;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * A naive attempt at StopWatch Benchmarking.
 * <p>
 * Will run code submitted to the {@link #benchmark(String, Runnable)} method
 * either X times for for Y milliseconds, whichever boundary is hit first. It
 * will do this Z number of times, where Z comprises some number of "warmup"
 * iterations followed by some number of "test" iterations. The average amount
 * of operations/millisecond will be calculated and output at the end.
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
    this(3_000, // max duration = 3 seconds
        10_000, // or 10,000 iterations, whichever comes first
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
    
    System.out.println("Running: " + name);
    System.out.println(String.format("Iterations: %d, Warmup Iterations: %d, Max Duration/Iteration: %dms, Max Times/Iteration: %d", testIterations, warmupIterations, maxDurationMillis, maxLoopIterations));      

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
