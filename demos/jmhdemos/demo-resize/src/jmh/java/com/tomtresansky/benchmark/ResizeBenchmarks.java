package com.tomtresansky.benchmark;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import com.google.common.collect.Lists;

public class ResizeBenchmarks {
  @Param({"1", "10", "100", "1000"})
  public int size;
  
  @Benchmark
  public Object presize() {
    List<String> list = new ArrayList<>(1000);
    
    for (int i=0; i<size; i++) {
      list.add("Tom");
    }
    
    return list;
  }
  
  @Benchmark
  public Object baseline() {
    List<String> list = new ArrayList<>();
    
    for (int i=0; i<size; i++) {
      list.add("Tom");
    }
    
    return list;
  }
  
  @Benchmark
  public Object guava_expected_size() {
    List<String> list = Lists.newArrayListWithExpectedSize(1000);
    
    for (int i=0; i<size; i++) {
      list.add("Tom");
    }
    
    return list;
  }
  
  @Benchmark
  public Object guava_capacity() {
    List<String> list = Lists.newArrayListWithCapacity(1000);
    
    for (int i=0; i<size; i++) {
      list.add("Tom");
    }
    
    return list;
  }
}
