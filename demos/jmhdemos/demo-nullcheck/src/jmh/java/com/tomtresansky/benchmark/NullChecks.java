package com.tomtresansky.benchmark;

import java.util.Optional;
import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * Compare basic {@code null == instance} check vs. {@link Optional#isPresent()}
 * check.
 * 
 * @author ttresans
 */
@State(Scope.Thread)
public class NullChecks {
  public Object instance;
  
  @Setup(Level.Iteration)
  public void setup() {
    instance = (new Random().nextBoolean() ? new Object() : null);
  }
  
  @Benchmark
  public int plain_old_null_check() {
    if (null != instance) {
      return instance.hashCode();
    } else {
      return 0;
    }
  }
  
  @Benchmark
  public int optional_present_check() {
    Optional<Object> maybeInstance = Optional.ofNullable(instance);
    if (maybeInstance.isPresent()) {
      return maybeInstance.get().hashCode();
    } else {
      return 0;
    }
  }
  
  @Benchmark
  public int optional_present_check_using_map() {
    return Optional.ofNullable(instance)
        .map(i -> i.hashCode())
        .orElse(0);
  }
}
