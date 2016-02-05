package com.tomtresansky.benchmark;

import java.util.Collection;
import java.util.Set;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Compare explicit loops vs. stream performance for filter and count operation.
 * 
 * @author ttresans
 */
@State(Scope.Thread)
public class Streams {
  public Set<Character> vowels = Sets.newHashSet('A', 'E', 'I', 'O', 'U');
  public Collection<String> names = Lists.newArrayList("Bob", "Carl", "Adam", "Tom", "Mike", "Aaron", "Emile", "Juan",
      "Steve", "Sally", "Ann", "Lindsay", "Michelle", "Emily", "Olivia", "Sammy");

  @Benchmark
  public long plain_old_loop() {
    long numNamesStartingWithVowels = 0;
    
    for (String name : names) {
      if (vowels.contains(name.charAt(0))) {
        numNamesStartingWithVowels++;
      }
    }
    
    return numNamesStartingWithVowels;
  }
  
  @Benchmark
  public long with_streams() {
    return names.stream()
        .filter(n -> vowels.contains(n.charAt(0)))
        .count();
  }
}
