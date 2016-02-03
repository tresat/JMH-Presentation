package com.tomtresansky.benchmark;

import org.openjdk.jmh.annotations.Benchmark;

import com.tomtresansky.application.UCMSModelCreation;

public class UCMSModelCreationBenchmarks {
  @Benchmark
  public Object create_object_baseline() {
    return UCMSModelCreation.create_object_baseline();
  }

  @Benchmark
  public Object create_dm_base() {
    return UCMSModelCreation.create_dm_base();
  }

  @Benchmark
  public Object create_dm_abstract_docket() {
    return UCMSModelCreation.create_dm_abstract_docket();
  }
}
