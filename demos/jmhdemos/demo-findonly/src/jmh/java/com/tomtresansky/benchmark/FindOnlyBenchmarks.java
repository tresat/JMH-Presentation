package com.tomtresansky.benchmark;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

@State(Scope.Thread)
public class FindOnlyBenchmarks {
  Set<String> names = Sets.newHashSet("Adam", "Bill", "Carl", "Doug", "Earl", "Fred", "Greg", "Hank", "Igor", "Jake",
      "Kane", "Luke", "Mike", "Nate", "Opie", "Pete", "Quen", "Rick", "Saul", "Tony", "Uffy", "Vick", "Will", "Xeke",
      "Yake", "Zack");
  

  @Param({"A", "C", "M", "Q", "Z"})
  public String start;

  @Benchmark
  public String custom_reducer() {
    return names.stream()
        .filter(n -> n.startsWith(start))
        .reduce(Finder.toOnlyElement()).get();
  }

  @Benchmark
  public String filter_and_iterables() {
    return Iterables.getOnlyElement(
        names.stream()
            .filter(n -> n.startsWith(start))
            .collect(Collectors.toList()));
  }

  @Benchmark
  public String count_and_find() {
    List<String> matches = names.stream()
        .filter(n -> n.startsWith(start))
        .collect(Collectors.toList());
        
    if (matches.size() == 1) {
      return matches.get(0);
    } else if (matches.size() > 1) {
      throw new IllegalStateException("Duplicate found!"); 
    } else {
      throw new NoSuchElementException();
    }
  }

  @Benchmark
  public String baseline() {
    String result = null;
    boolean found = false;

    for (String n : names) {
      if (n.startsWith(start)) {
        if (!found) {
          result = n;
          found = true;
        } else {
          throw new IllegalStateException("Duplicate found!");
        }
      }
    }

    if (found) {
      return result;
    } else {
      throw new NoSuchElementException();
    }
  }
}
