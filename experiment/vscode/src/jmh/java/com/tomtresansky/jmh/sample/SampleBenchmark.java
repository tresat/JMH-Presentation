package com.tomtresansky.jmh.sample;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * A sample benchmark class.
 * <p>
 * Benchmark classes must <strong>NOT</strong> be {@code final}.
 *
 * @author ttresans
 */
public class SampleBenchmark {
    @Benchmark
    public void sqrtBenchmark(){
        Math.sqrt(3.0);
    }
}
